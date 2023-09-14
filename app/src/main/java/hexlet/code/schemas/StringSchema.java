package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        addValidator("required", value -> (value instanceof String) && (!value.equals("")));
        return this;
    }

    public StringSchema minLength(int length) {
        addValidator("minLength", value -> (value == null) || (value.toString().length() >= length));
        return this;
    }

    public StringSchema contains(String substring) {
        addValidator("contains", value -> (value != null) && (value.toString().contains(substring)));
        return this;
    }

}
