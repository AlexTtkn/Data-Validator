package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public MapSchema required() {
        addError("required", value -> value instanceof Map);
        return this;
    }

    public MapSchema sizeof(int size) {
        addError("sizeof", value -> value == null || ((Map<?, ?>) value).size() == size);
        return this;
    }
}
