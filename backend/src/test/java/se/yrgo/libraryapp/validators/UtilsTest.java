package se.yrgo.libraryapp.validators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/util-only-letters-and-whitespace.csv", numLinesToSkip = 1)
    void onlyLettersAndWhitespaceFiltersCorrectly(String stringToCheck, String expectedString) {
        String filteredString = Utils.onlyLettersAndWhitespace(stringToCheck);
        assertThat(filteredString).isEqualTo(expectedString);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/util-clean-and-unleet.csv", numLinesToSkip = 1)
    void cleanAndUnLeetFiltersCorrectly(String stringToCheck, String expectedString) {
        String filteredString = Utils.cleanAndUnLeet(stringToCheck);
        assertThat(filteredString).isEqualTo(expectedString);
    }

}
