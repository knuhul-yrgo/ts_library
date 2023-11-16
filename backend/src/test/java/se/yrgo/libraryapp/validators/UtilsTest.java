package se.yrgo.libraryapp.validators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @ParameterizedTest
    @CsvFileSource
    void onlyLettersAndWhitespaceFiltersCorrectly(String stringToCheck, String expectedString) {
        String filteredString = Utils.onlyLettersAndWhitespace(stringToCheck);
        assertThat(filteredString).isEqualTo(expectedString);
    }

}
