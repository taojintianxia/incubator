package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileOperation {

    public static void main(String... args) throws IOException {
        File file = new File("/Users/nianjun/Desktop/job.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        while (line != null) {
            System.out.print(line.trim() + ",");
            line = bufferedReader.readLine();
            ;
        }
    }

}
