package by.epamtc.library.scaner;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scan {
    public static List<StringBuilder> readTextFromFile(String data) throws IOException {
        List<StringBuilder> stringList = new ArrayList<>();
        try{
            Path path = Paths.get(data);
            Scanner scanner = new Scanner(path);

            while (scanner.hasNextLine()) {
                stringList.add(new StringBuilder(scanner.nextLine()));
            }
        }catch (NoSuchFileException e){
            throw new IOException("problem with getting data from file", e);
        }
        return stringList;
    }
}
