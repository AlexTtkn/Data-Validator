package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {
    private final Map<String, Predicate<Object>> errors = new HashMap<>();

    public boolean isValid(Object obj) {
        return errors.values().stream().allMatch(error -> error.test(obj));
    }

    public void addError(String errorType, Predicate<Object> error) {
        errors.put(errorType, error);
    }
}
