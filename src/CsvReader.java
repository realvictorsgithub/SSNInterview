import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CsvReader {
    void setup(String csvPath, List<String> testDataStruct) throws IOException {

        Scanner sc = new Scanner(new File(csvPath));
        sc.useDelimiter(",");

        while (sc.hasNext()) {
            String number = sc.next();
            number = CsvHelper.convertSSNtoStandardFormat(number);
            testDataStruct.add(number);
        }
    }
}
