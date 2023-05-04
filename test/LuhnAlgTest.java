import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LuhnAlgTest {
    LuhnAlg luhnAlg = new LuhnAlg();

    final String orgPath = "./resources/GiltigaOrganisationsnummer.csv";
    final String personPath = "./resources/GiltigaPersonnummer.csv";
    final String samordPath = "./resources/GiltigaSamordningsnummer.csv";
    final String badPersonPath = "./resources/OgiltigaPersonnumer.csv";


    void setup(String csvPath, List<String> testDataStruct) throws IOException {

        Scanner sc = new Scanner(new File(csvPath));
        sc.useDelimiter(",");

        while (sc.hasNext()) {
            String number = sc.next();
            number = CsvHelper.convertSSNtoStandardFormat(number);
            testDataStruct.add(number);
        }
    }


    @Test
    void luhnOrgValidatorGood() throws IOException {
        List<String> orgData = new ArrayList<>();

        setup(orgPath, orgData);


        for (String x : orgData) {
            assertTrue(luhnAlg.luhnValidator(x));
        }


    }

    @Test
    void luhnPersonValidatorGood() throws IOException {
        List<String> personData = new ArrayList<>();

        setup(personPath, personData);

        for (String x : personData) {
            assertTrue(luhnAlg.luhnValidator(x));
        }

    }

    @Test
    void luhnSamordValidatorGood() throws IOException {
        List<String> samordData = new ArrayList<>();
        setup(samordPath, samordData);
        for (String x : samordData) {
            assertTrue(luhnAlg.luhnValidator(x));
        }
    }


    @Test
    void luhnValidatorBad() throws IOException {
        List<String> badData = new ArrayList<>();
        setup(badPersonPath, badData);

        assertFalse(luhnAlg.luhnValidator(badData.get(0)));

        //This is an edge case, the algorithm SHOULD pass this but the program SHOULD NOT
        assertTrue(luhnAlg.luhnValidator(badData.get(1)));
    }
}

