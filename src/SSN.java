public class SSN {

    private enum types {
        Organization, Temporary, Regular
    }

    private String ssn;
    private types type;
    private boolean leapYear;
    public boolean validDate = true;

    SSN(String ssn) {
        this.ssn = ssn;
        this.type = verifyType();
        if (!type.equals(types.Organization)) {
            validateDate();
        }
    }

    /**
     * org validation involves checking 3,4 index being at least 20 (prescribed format)
     * temp validation involves checking 5,6 index being above 60 (as 60 is added)
     * rest falls to regular type
     *
     * @return enum type
     */
    private types verifyType() {
        if (SSNHelper.orgValidator(this.ssn)) {
            return types.Organization;
        } else if (SSNHelper.tempSSNValidator(this.ssn)) {
            return types.Temporary;
        } else {
            return types.Regular;
        }
    }

    /**
     * Validates whether the date of the SSN is valid
     * Has to handle 2 types; regular and temporary
     * NOTE: Temporary has 6 added to the first digit of the days, hence some extra manipulation needs to be done before validating
     * NOTE: Leap years exist, leapValidator accounts for them by checking divisibility by 4 (last 2 digits of any number)
     */
    private void validateDate() {
        this.leapYear = SSNHelper.leapValidator(ssn);
        if (type.equals(types.Regular)) {
            this.validDate = SSNHelper.validDateValidator(ssn.substring(0, 6));
        } else {
            this.validDate = SSNHelper.validDateValidator(SSNHelper.tempSSNDateValidator(this.ssn).substring(0, 6));
        }
    }

    public String getSSN() {
        return ssn;
    }

    public types getType() {
        return type;
    }
}

