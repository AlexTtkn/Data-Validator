package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatorTest {
    private final Validator validator = new Validator();

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
        "5, 2, 4, false"
    })
    void testWithRequirementForNumberSchema(int number, int min, int max, boolean expectedResult) {
        boolean actual = validator.number().required().positive().range(min, max).isValid(number);
        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    void testWithNull() {
        String text = "";
        boolean actual = new StringSchema().required().isValid(text);
        Assertions.assertNotNull(actual);
    }
}
