package algoSec;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessor {

    public static Set<String> readFile(String filePath){
        if (filePath == null)
            return null;
        Set<String> wordSet = new HashSet<>();
        Path path = Paths.get(filePath);
        try {
            Stream<String> lines = Files.lines(path);
            wordSet = lines.map(String::toLowerCase)
                            .flatMap(line -> Stream.of(line.split("\\s+")))
                            .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordSet;
    }
}
