package by.epamtc.library.scaner;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scan {
    public static List<String> readTextFromFile(String data) throws IOException {
        List<String> stringList = new ArrayList<>();
        try{
//            String fileName = "src/by/epamtc/resources/users.txt";
            Path path = Paths.get(data);
            Scanner scanner = new Scanner(path);

            while (scanner.hasNextLine()) {
                stringList.add(scanner.nextLine());
            }
        }catch (NoSuchFileException e){
            throw new IOException("problem with getting data from file", e);
        }
        return stringList;
    }
}
