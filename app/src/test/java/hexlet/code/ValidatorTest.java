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
    void validatorTestWithRequirement(String text, String requirement, int length, boolean expectedResult) {

        boolean actual = validator.string().contains(requirement).minLength(length).isValid(text);
        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    void validatorTestWithNull() {
        String text = "";
        boolean actual = new StringSchema().required().isValid(text);
        Assertions.assertNotNull(actual);
    }
}