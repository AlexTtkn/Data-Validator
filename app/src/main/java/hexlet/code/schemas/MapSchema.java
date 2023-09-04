package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public MapSchema required() {
        addValidator("required", value -> value instanceof Map);
        return this;
    }

    public MapSchema sizeof(int size) {
        addValidator("sizeof", value -> value == null || ((Map<?, ?>) value).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addValidator("shape", value -> schemas.entrySet().stream()
                .allMatch(entry -> entry.getValue().isValid(((Map<?, ?>) value).get(entry.getKey()))));
        return this;
    }
}
