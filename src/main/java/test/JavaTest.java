package test;

import java.util.Random;

import com.google.common.base.Optional;

public class JavaTest {

    // public static void main(String... args) throws IOException {
    // String grpc_plugin =
    // "/Users/nianjun/Work/tools/grpc-java/compiler/build/exe/java_plugin/protoc-gen-grpc-java";
    // String[] cmds =
    // new String[] {"sh", "-c", "cd /Users/nianjun/Work/workspace/idl-transformer/idl/1487233348006
    // ; "
    // + "export PATH=$PATH:/usr/local/bin/ ; echo $PATH ; sh
    // /Users/nianjun/Work/tools/grpc-java/compiler/compiler.sh ./helloworld.proto"};
    //
    // File file = new File("/Users/nianjun/Work/tools/grpc-java/compiler/compiler.sh");
    // Process process = Runtime.getRuntime().exec(cmds);
    // BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
    // String line = "";
    // while ((line = input.readLine()) != null) {
    // System.out.println(line);
    // }
    // }

    public static void main(String... args) {
        String nullableMaybe = null;
        if (new Random().nextBoolean()) {
            nullableMaybe = "xiba";
        }
        String string = Optional.fromNullable(nullableMaybe).or("默认值");

        System.out.println(string);
    }

}
