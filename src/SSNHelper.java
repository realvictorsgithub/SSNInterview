import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SSNHelper {

    /**
     * This works under the conception that in order to validate a date, one can cram a date in dateformat and let it crash, if it crashes then the date is invalid
     * To enforce calendar-related rules, setLenient is used though unforeseen edge cases may exist.
     * @param standardSSN
     * @return true/false on valid date
     */
    public static  boolean validDateValidator(String standardSSN)  {
        try {
            DateFormat df = new SimpleDateFormat("yyMMdd");
            df.setLenient(false);
            df.parse(standardSSN);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static boolean leapValidator(String standardSSN) {
        return Integer.parseInt(standardSSN.substring(0, 2)) % 4 == 0;
    }

    public static boolean orgValidator(String standardSSN) {

        return Integer.parseInt(standardSSN.substring(2, 4)) > 19;
    }

    public static boolean tempSSNValidator(String standardSSN) {
        return Integer.parseInt(standardSSN.substring(4, 6)) > 60;
    }

    /**
     *
     * @param standardSSN standardized SSN string
     * @return modified string that would correspond to pre-modification SSN
     */
    public static String tempSSNDateValidator(String standardSSN) {
        int modifiedNumber = Integer.parseInt(String.valueOf(standardSSN.charAt(4)));
        modifiedNumber = modifiedNumber - 6;
        return standardSSN.substring(0, 4) + modifiedNumber + standardSSN.substring(6);
    }
}
