package se.yrgo.libraryapp.dao;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import javax.sql.DataSource;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import com.radcortez.flyway.test.annotation.H2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import se.yrgo.libraryapp.entities.User;
import se.yrgo.libraryapp.entities.UserId;

import java.util.Optional;

@Tag("integration")
@H2
public class UserDaoIntegrationTest {
    private static DataSource ds;

    @BeforeAll
    static void initDataSource() {
        //this way we do not need to create a new datasource every time
        final JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:test");
        UserDaoIntegrationTest.ds = ds;
    }

    @Test
    void getUserByName() {
        final String username = "test";
        final UserId userId = UserId.of(1);

        UserDao userDao = new UserDao(ds);
        Optional<User> maybeUser = userDao.get(username);

        assertThat(maybeUser).isPresent();
        assertThat(maybeUser.get().getId()).isEqualTo(userId);
    }

    @ParameterizedTest
    @ValueSource(strings = { "l@sse", "k-n-u-t", "why.Not", "lass3", "SM_ART" })
    void persistUser(String username) {
        UserDao userDao = new UserDao(ds);
        userDao.persistUser(username, "Bosse", "xxxxxxxxx");
        Optional<User> maybeUser = userDao.get(username);

        assertThat(maybeUser).isPresent();
        assertThat(maybeUser.get().getName()).isEqualTo(username);
    }
}
