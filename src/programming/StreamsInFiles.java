package programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class StreamsInFiles {

    public static void main(String[] args) throws IOException {
        //Read each line
        Files.lines(Paths.get("InputTextFile.txt"))
                .forEach(System.out::println);

        //Find the unique words in sorted order
        System.out.println("Find the unique words in sorted order");
        Files.lines(Paths.get("InputTextFile.txt"))
                .map(line -> line.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        //Print all the files/directories in the directory
        System.out.println("Print all the files in the directory");
        Files.list(Paths.get("src/programming"))
                .forEach(System.out::println);

        //Print all the directories alone in the directory
        System.out.println("Print all the directories alone in the directory");
        Files.list(Paths.get("src/programming"))
//                .filter(path -> Files.isDirectory(path))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }
}
