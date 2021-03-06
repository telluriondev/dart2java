#!/usr/bin/env dart
// Copyright 2016, the Dart project authors.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/// Command line entry point for Dart To Java transpiler (dart2java).

import 'dart:async';
import 'dart:io';
import 'package:analyzer/src/generated/engine.dart' show AnalysisEngine;
import 'package:args/src/usage_exception.dart' show UsageException;
import 'package:bazel_worker/bazel_worker.dart';
import 'package:dart2java/src/compiler/runner.dart';

void main(List<String> args) {
  // Always returns a new modifiable list.
  args = _preprocessArgs(args);

  if (args.contains('--persistent_worker')) {
    new _CompilerWorker(args..remove('--persistent_worker')).run();
  } else {
    exitCode = _compile(args);
  }
}

typedef void MessageHandler(Object message);

/// Runs a single compile command, and returns an exit code.
int _compile(List<String> args, {MessageHandler messageHandler}) {
  try {
    Runner.run(args);
  } catch (e, s) {
    return _handleError(e, s, args, messageHandler: messageHandler);
  }
  return EXIT_CODE_OK;
}

/// Runs the compiler worker loop.
class _CompilerWorker extends AsyncWorkerLoop {
  /// The original args supplied to the executable.
  final List<String> _startupArgs;

  _CompilerWorker(this._startupArgs) : super();

  /// Performs each individual work request.
  @override
  Future<WorkResponse> performRequest(WorkRequest request) {
    var args = _startupArgs.toList()..addAll(request.arguments);

    var output = new StringBuffer();
    var exitCode = _compile(args, messageHandler: output.writeln);
    AnalysisEngine.instance.clearCaches();
    return new Future.value(new WorkResponse()
      ..exitCode = exitCode
      ..output = output.toString());
  }
}

/// Handles [error] in a uniform fashion. Returns the proper exit code and calls
/// [messageHandler] with messages.
int _handleError(dynamic error, dynamic stackTrace, List<String> args,
    {MessageHandler messageHandler}) {
  messageHandler ??= print;

  if (error is UsageException) {
    // Incorrect usage, input file not found, etc.
    messageHandler(error);
    return 64;
  } else if (error is CompileErrorException) {
    // Code has error(s) and failed to compile.
    messageHandler(error);
    return 1;
  } else {
    // Anything else is likely a compiler bug.
    //
    // --unsafe-force-compile is a bit of a grey area, but it's nice not to
    // crash while compiling
    // (of course, output code may crash, if it had errors).
    //
    messageHandler("");
    messageHandler("We're sorry, you've found a bug in our compiler.");
    messageHandler("You can report this bug at:");
    messageHandler("    https://github.com/dart-lang/dev_compiler/issues");
    messageHandler("");
    messageHandler(
        "Please include the information below in your report, along with");
    messageHandler(
        "any other information that may help us track it down. Thanks!");
    messageHandler("");
    messageHandler("    dartdevc arguments: " + args.join(' '));
    messageHandler("    dart --version: ${Platform.version}");
    messageHandler("");
    messageHandler("```");
    messageHandler(error);
    messageHandler(stackTrace);
    messageHandler("```");
    return 70;
  }
}

/// Always returns a new modifiable list.
///
/// If the final arg is `@file_path` then read in all the lines of that file
/// and add those as args.
///
/// Bazel actions that support workers must provide all their per-WorkRequest
/// arguments in a file like this instead of as normal args.
List<String> _preprocessArgs(List<String> args) {
  args = new List.from(args);
  if (args.isNotEmpty && args.last.startsWith('@')) {
    var fileArg = args.removeLast();
    args.addAll(new File(fileArg.substring(1)).readAsLinesSync());
  }
  return args;
}
