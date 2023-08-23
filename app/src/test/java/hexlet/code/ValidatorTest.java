package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;


class ValidatorTest {
    private final Validator validator = new Validator();
    private final Map<String, BaseSchema> schemas = new HashMap<>();

    @ParameterizedTest
    @CsvSource({
        "test with all correct requirement, test, 5, true",
        "test with wrong length, test, 50, false",
        "test with wrong contains, alex, 7, false",
    })
    void testWithRequirementForStingSchema(String text, String requirement, int length, boolean expectedResult) {
        boolean actual = validator.string().contains(requirement).minLength(length).isValid(text);
        Assertions.assertEquals(expectedResult, actual);
    }

    @ParameterizedTest
    @CsvSource({
        "5, 4, 6, true",
        "5, 6, 8, false",
        "5, 2, 4, false",
        "0, 0, 0, false"
    })
    void testWithRequirementForNumberSchema(int number, int min, int max, boolean expectedResult) {
        boolean actual = validator.number().positive().range(min, max).isValid(number);
        Assertions.assertEquals(expectedResult, actual);
    }

    @ParameterizedTest
    @CsvSource({
        "key1, value1, 1, true",
        "key1, value1, 2, false",
        "key1, value1, 0, false",
    })
    void testWithRequirementForMapSchema(String key, String value, int size, boolean expectedResult) {
        Map<String, String> testMap = new HashMap<>();
        testMap.put(key, value);
        boolean actual = validator.map().required().sizeof(size).isValid(testMap);
        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    void testWithNullStringSchema() {
        boolean actual = validator.string().required().isValid(null);
        Assertions.assertFalse(actual);
    }

    @Test
    void testWithNullNumberSchema() {
        boolean actual = validator.number().required().isValid(null);
        Assertions.assertFalse(actual);
    }

    @Test
    void testWithNullMapSchema() {
        boolean actual = validator.map().required().isValid(null);
        Assertions.assertFalse(actual);
    }

    @Test
    void testShape1() {
        MapSchema schema = validator.map();
        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        schema.isValid(human1);

        Assertions.assertTrue(schema.isValid(human1));
    }

    @Test
    void testShape2() {
        MapSchema schema = validator.map();
        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());
        schema.shape(schemas);

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);

        Assertions.assertTrue(schema.isValid(human2));
    }

    @Test
    void testShape3() {
        MapSchema schema = validator.map();
        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());
        schema.shape(schemas);

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        schema.isValid(human3);

        Assertions.assertFalse(schema.isValid(human3));
    }

    @Test
    void testShape4() {
        MapSchema schema = validator.map();
        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());
        schema.shape(schemas);

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        schema.isValid(human4);

        Assertions.assertFalse(schema.isValid(human4));
    }
}
