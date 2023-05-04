import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws IOException {
        final String path = args[0];

        Logger logger = Logger.getLogger(Main.class.getName());
        LuhnAlg validator = new LuhnAlg();
        CsvReader csvReader = new CsvReader();

        List<String> data = new ArrayList<>();

        csvReader.setup(path, data);

        for (String ssn : data) {

            SSN dataSsn = new SSN(ssn);
            if (!dataSsn.validDate) {
                logger.log(Level.SEVERE, "Invalid date SSN: " + dataSsn.getSSN());
            } else {
                if (validator.luhnValidator(dataSsn.getSSN())) {
                    System.out.println("SSN: " + dataSsn.getSSN() + " is valid and is of type: " + dataSsn.getType());
                }
                else {
                    logger.log(Level.SEVERE, "Invalid validation of SSN: " + dataSsn.getSSN());

                }
            }
        }
    }
}

