import java.util.Arrays;

public class LuhnAlg {

    /**
     * The algortihm for Luhn validation is well described online
     *
     * @param standardSSN Standardized SSN number
     * @return true-false on validation
     */
    public boolean luhnValidator(String standardSSN) {
        int[] arr = new int[standardSSN.length()];

        for (int i = 0; i < standardSSN.length(); i++) {
            char c = standardSSN.charAt(i);
            arr[i] = Integer.parseInt(String.valueOf(c));
        }

        for (int i = arr.length - 2; i >= 0; i = i - 2) {
            int num = arr[i];
            num = num * 2;
            if (num > 9) {
                num = num % 10 + num / 10;
            }
            arr[i] = num;
        }
        int sum = sumDigits(arr);

        return sum % 10 == 0;
    }

    private int sumDigits(int[] arr) {
        return Arrays.stream(arr).sum();
    }

}
