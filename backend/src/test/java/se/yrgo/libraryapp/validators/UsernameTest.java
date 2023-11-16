package se.yrgo.libraryapp.validators;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class UsernameTest {

    @ParameterizedTest
    @ValueSource(strings = { "l@sse", "k-n-u-t", "why.Not", "lass3", "SM_ART" })
    void correctUsername(String username) {
        assertThat(Username.validate(username)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "knu,t", "början", "hej/nej", "<hej>", "hej svejs", "     " })
    void incorrectUsernameCharacters(String username) {
        assertThat(Username.validate(username)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = { "hej" })
    @EmptySource
    void incorrectUsernameLength(String username) {
        assertThat(Username.validate(username)).isFalse();
    }
}
