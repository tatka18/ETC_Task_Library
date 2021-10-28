package by.epamtc.library.scaner;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scan {
    public static List<String> readTextFromFile() throws IOException {
        String fileName = "src/by/epamtc/resources/users.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        List<String> stringList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            stringList.add(scanner.nextLine());
        }
        return stringList;
    }
}
