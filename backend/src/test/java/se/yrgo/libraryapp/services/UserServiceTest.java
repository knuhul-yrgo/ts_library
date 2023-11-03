import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import se.yrgo.libraryapp.dao.UserDao;
import se.yrgo.libraryapp.entities.User;
import se.yrgo.libraryapp.entities.UserId;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class UserServiceTest {
    @Mock
    private UserDao userDao;

    @Test
    void correctLogin() {
        final UserId id = UserId.of(1);
        final String username = "testuser";
        final String realname = "bosse";
        final String password = "password";
        final String passwordHash = "$argon2i$v=19$m=16,t=2,p=1$QldXU09Sc2dzOWdUalBKQw$LgKb6x4usOpDLTlXCBVhxA";
        final User user = new User(id, username, realname, passwordHash);
        when(userDao.get(username)).thenReturn(Optional.of(user));
        UserService userService = new UserService(userDao);
        assertThat(userService.validate(username,
                password)).isEqualTo(Optional.of(id));
    }
}
