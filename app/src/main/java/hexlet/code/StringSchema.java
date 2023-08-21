package hexlet.code;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
        addError("required", value -> (value instanceof String) && (!value.equals("")));
        return this;
    }

    public StringSchema minLength(int length) {
        addError("minLength", value -> (value == null) || (value.toString().length() >= length));
        return this;
    }

    public StringSchema contains(String substring) {
        addError("contains", value -> (value != null) && (value.toString().contains(substring)));
        return this;
    }

}
