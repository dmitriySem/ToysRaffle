package macro;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderListToysFromFile {

    private String CSV_FILE;

    private final String COMMA_DELIMITER = ";";

    public ReaderListToysFromFile(String CSV_FILE) {
        this.CSV_FILE = CSV_FILE;
    }

    public List<List<String>>  readFile(){
        List<List<String>> collect = new ArrayList<>();
        try {
            collect = Files.readAllLines(Paths.get(System.getProperty("user.dir") + File.separator + CSV_FILE))
                    .stream()
                    .map(line -> Arrays.asList(line.split(COMMA_DELIMITER)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return collect;
        }
    }

}
