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

/**
 * Created by stanm on 6/20/16.
 */
public class InvokeInterface1A {

    private interface I {
        int getInteger();
    }

    private static class A implements I {
        public int getInteger() {
            return 1;
        }
    }

    static volatile I[] is = {new A()};

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: ./a.out <outer-loop-iterations> <inner-loop-iterations>");
            return;
        }

        int outerRep, innerRep;
        try {
            outerRep = Integer.parseInt(args[0]);
            innerRep = Integer.parseInt(args[1]);
        } catch (Throwable _) {
            System.err.println("Error: could not parse command line argument.");
            return;
        }

        System.out.println("iteration,rep " + innerRep);
        for (int id = 0; id < outerRep; ++id) {
            System.out.print(id + ",");
            {
                long tm1 = System.nanoTime();
                for (int k = 0; k < innerRep; ++k) {
                    is[innerRep % 1].getInteger();
                }
                long tm2 = System.nanoTime();
                System.out.println(1.0 * (tm2 - tm1) / innerRep);
            }
        }
    }
}
