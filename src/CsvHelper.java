
public class CsvHelper {

    /**
     * This will remove the special signs covered by regex, including return and newline and trim down the number to 10 digits only
     * This assumes that only those special signs exist and that the number will be more or less correctly formatted
     * @param number ssn String
     * @return standardized ssn
     *
     */
    public static String convertSSNtoStandardFormat(String number) {
        number = removeSpecialChars(number);
        number = removeAppendedYears(number);
        return number;
    }
    public static String removeSpecialChars(String number) {
        number = number.replaceAll("[-+.^:,\\r|\\n]", "");

        return number;
    }
    public static String removeAppendedYears(String number) {
        if (number.length()>10) {
            number = number.substring(2);
        }
        return number;
    }


    }

