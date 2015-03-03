var isolate;
(function(exports) {
  'use strict';
  class IsolateSpawnException extends dart.Object {
    IsolateSpawnException(message) {
      this.message = message;
    }
    toString() {
      return `IsolateSpawnException: ${this.message}`;
    }
  }
  let _pause = Symbol('_pause');
  class Isolate extends dart.Object {
    Isolate(controlPort, opt$) {
      let pauseCapability = opt$.pauseCapability === void 0 ? null : opt$.pauseCapability;
      let terminateCapability = opt$.terminateCapability === void 0 ? null : opt$.terminateCapability;
      this.controlPort = controlPort;
      this.pauseCapability = pauseCapability;
      this.terminateCapability = terminateCapability;
    }
    static get current() {
      return dart.as(_currentIsolateCache, Isolate);
    }
    static spawn(entryPoint, message, opt$) {
      let paused = opt$.paused === void 0 ? false : opt$.paused;
      try {
        return dart.as(_isolate_helper.IsolateNatives.spawnFunction(entryPoint, message, paused).then((msg) => new Isolate(dart.as(dart.dindex(msg, 1), SendPort), {pauseCapability: dart.as(dart.dindex(msg, 2), Capability), terminateCapability: dart.as(dart.dindex(msg, 3), Capability)})), async.Future$(Isolate));
      } catch (e) {
        let st = dart.stackTrace(e);
        return new async.Future.error(e, st);
      }

    }
    static spawnUri(uri, args, message, opt$) {
      let paused = opt$.paused === void 0 ? false : opt$.paused;
      let packageRoot = opt$.packageRoot === void 0 ? null : opt$.packageRoot;
      if (packageRoot !== null)
        throw new core.UnimplementedError("packageRoot");
      try {
        if (dart.is(args, core.List$(core.String))) {
          for (let i = 0; dart.notNull(i) < dart.notNull(args.length); dart.notNull(i)++) {
            if (!(typeof args.get(i) == string)) {
              throw new core.ArgumentError(`Args must be a list of Strings ${args}`);
            }
          }
        } else if (args !== null) {
          throw new core.ArgumentError(`Args must be a list of Strings ${args}`);
        }
        return dart.as(_isolate_helper.IsolateNatives.spawnUri(uri, args, message, paused).then((msg) => new Isolate(dart.as(dart.dindex(msg, 1), SendPort), {pauseCapability: dart.as(dart.dindex(msg, 2), Capability), terminateCapability: dart.as(dart.dindex(msg, 3), Capability)})), async.Future$(Isolate));
      } catch (e) {
        let st = dart.stackTrace(e);
        return new async.Future.error(e, st);
      }

    }
    pause(resumeCapability) {
      if (resumeCapability === void 0)
        resumeCapability = null;
      if (resumeCapability === null)
        resumeCapability = new Capability();
      this[_pause](resumeCapability);
      return resumeCapability;
    }
    [_pause](resumeCapability) {
      let message = new core.List(3);
      dart.dsetindex(message, 0, "pause");
      dart.dsetindex(message, 1, this.pauseCapability);
      dart.dsetindex(message, 2, resumeCapability);
      this.controlPort.send(message);
    }
    resume(resumeCapability) {
      let message = new core.List(2);
      dart.dsetindex(message, 0, "resume");
      dart.dsetindex(message, 1, resumeCapability);
      this.controlPort.send(message);
    }
    addOnExitListener(responsePort) {
      let message = new core.List(2);
      dart.dsetindex(message, 0, "add-ondone");
      dart.dsetindex(message, 1, responsePort);
      this.controlPort.send(message);
    }
    removeOnExitListener(responsePort) {
      let message = new core.List(2);
      dart.dsetindex(message, 0, "remove-ondone");
      dart.dsetindex(message, 1, responsePort);
      this.controlPort.send(message);
    }
    setErrorsFatal(errorsAreFatal) {
      let message = new core.List(3);
      dart.dsetindex(message, 0, "set-errors-fatal");
      dart.dsetindex(message, 1, this.terminateCapability);
      dart.dsetindex(message, 2, errorsAreFatal);
      this.controlPort.send(message);
    }
    kill(priority) {
      if (priority === void 0)
        priority = BEFORE_NEXT_EVENT;
      this.controlPort.send(new List.from(["kill", this.terminateCapability, priority]));
    }
    ping(responsePort, pingType) {
      if (pingType === void 0)
        pingType = IMMEDIATE;
      let message = new core.List(3);
      dart.dsetindex(message, 0, "ping");
      dart.dsetindex(message, 1, responsePort);
      dart.dsetindex(message, 2, pingType);
      this.controlPort.send(message);
    }
    addErrorListener(port) {
      let message = new core.List(2);
      dart.dsetindex(message, 0, "getErrors");
      dart.dsetindex(message, 1, port);
      this.controlPort.send(message);
    }
    removeErrorListener(port) {
      let message = new core.List(2);
      dart.dsetindex(message, 0, "stopErrors");
      dart.dsetindex(message, 1, port);
      this.controlPort.send(message);
    }
    get errors() {
      let controller = null;
      let port = null;
      // Function handleError: (dynamic) → void
      function handleError(message) {
        let errorDescription = dart.as(dart.dindex(message, 0), core.String);
        let stackDescription = dart.as(dart.dindex(message, 1), core.String);
        let error = new RemoteError(errorDescription, stackDescription);
        controller.addError(error, error.stackTrace);
      }
      controller = new async.StreamController.broadcast({sync: true, onListen: (() => {
          port = new RawReceivePort(handleError);
          this.addErrorListener(port.sendPort);
        }).bind(this), onCancel: (() => {
          this.removeErrorListener(port.sendPort);
          port.close();
          port = null;
        }).bind(this)});
      return controller.stream;
    }
  }
  Isolate.IMMEDIATE = 0;
  Isolate.BEFORE_NEXT_EVENT = 1;
  Isolate.AS_EVENT = 2;
  dart.defineLazyProperties(Isolate, {
    get _currentIsolateCache() {
      return _isolate_helper.IsolateNatives.currentIsolate;
    }
  });
  class SendPort extends dart.Object {
  }
  class ReceivePort extends dart.Object {
    ReceivePort() {
      return new _isolate_helper.ReceivePortImpl();
    }
    ReceivePort$fromRawReceivePort(rawPort) {
      return new _isolate_helper.ReceivePortImpl.fromRawReceivePort(rawPort);
    }
  }
  dart.defineNamedConstructor(ReceivePort, 'fromRawReceivePort');
  class RawReceivePort extends dart.Object {
    RawReceivePort(handler) {
      if (handler === void 0)
        handler = null;
      return new _isolate_helper.RawReceivePortImpl(handler);
    }
  }
  class _IsolateUnhandledException extends dart.Object {
    _IsolateUnhandledException(message, source, stackTrace) {
      this.message = message;
      this.source = source;
      this.stackTrace = stackTrace;
    }
    toString() {
      return 'IsolateUnhandledException: exception while handling message: ' + `${this.message} \n  ` + `${dart.dinvoke(dart.dinvoke(this.source, 'toString'), 'replaceAll', "\n", "\n  ")}\n` + 'original stack trace:\n  ' + `${this.stackTrace.toString().replaceAll("\n", "\n  ")}`;
    }
  }
  let _description = Symbol('_description');
  class RemoteError extends dart.Object {
    RemoteError(description, stackDescription) {
      this[_description] = description;
      this.stackTrace = new _RemoteStackTrace(stackDescription);
    }
    toString() {
      return this[_description];
    }
  }
  let _trace = Symbol('_trace');
  class _RemoteStackTrace extends dart.Object {
    _RemoteStackTrace($_trace) {
      this[_trace] = $_trace;
    }
    toString() {
      return this[_trace];
    }
  }
  class Capability extends dart.Object {
    Capability() {
      return new _isolate_helper.CapabilityImpl();
    }
  }
  // Exports:
  exports.IsolateSpawnException = IsolateSpawnException;
  exports.Isolate = Isolate;
  exports.SendPort = SendPort;
  exports.ReceivePort = ReceivePort;
  exports.RawReceivePort = RawReceivePort;
  exports.RemoteError = RemoteError;
  exports.Capability = Capability;
})(isolate || (isolate = {}));