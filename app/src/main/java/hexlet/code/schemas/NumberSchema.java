package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addValidator("required", value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addValidator("positive", value -> (value == null) || value instanceof Integer && ((int) value > 0));
        return this;
    }

    public NumberSchema range(int min, int max) {
        addValidator("range", value -> value == null || ((int) value >= min && (int) value <= max));
        return this;
    }
}
