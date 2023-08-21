package hexlet.code;

public class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addError("required", value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addError("positive", value -> (value == null) || ((int) value > 0));
        return this;
    }

    public NumberSchema range(int min, int max) {
        addError("range", value -> value == null || ((int) value >= min && (int) value <= max));
        return this;
    }
}
