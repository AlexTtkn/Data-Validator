package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {
    private final Map<String, Predicate<Object>> validator = new HashMap<>();

    public boolean isValid(Object obj) {
        return validator.values().stream().allMatch(error -> error.test(obj));
    }

    public void addValidator(String errorType, Predicate<Object> error) {
        validator.put(errorType, error);
    }
}
