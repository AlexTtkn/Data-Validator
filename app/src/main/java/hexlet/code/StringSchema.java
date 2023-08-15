package hexlet.code;

public class StringSchema {
    private boolean required;
    private int minLength;
    private String contains;


    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int length) {
        minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        contains = substring;
        return this;
    }

    public boolean isValid(String value) {
        if (isRequiredInvalid(value)) {
            return false;
        }
        if (isLengthInvalid(value)) {
            return false;
        }
        if (isContainsInvalid(value)) {
            return false;
        }
        return true;
    }

    private boolean isRequiredInvalid(String value) {
        return required && (value == null || value.isEmpty());
    }

    private boolean isLengthInvalid(String value) {
        return value != null && value.length() < minLength;
    }

    private boolean isContainsInvalid(String value) {
        return contains != null && !value.contains(contains);
    }
}
