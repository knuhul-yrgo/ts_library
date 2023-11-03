package se.yrgo.libraryapp.services;

import java.util.Optional;
import javax.inject.Inject;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import se.yrgo.libraryapp.dao.UserDao;
import se.yrgo.libraryapp.entities.User;
import se.yrgo.libraryapp.entities.UserId;

public class UserService {
    private UserDao userDao;

    @Inject
    UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<UserId> validate(String username, String password) {
        Optional<User> maybeUser = userDao.get(username);
        if (maybeUser.isEmpty()) {
            return Optional.empty();
        }
        User user = maybeUser.get();
        Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
        if (!encoder.matches(password, user.getPasswordHash())) {
            return Optional.empty();
        }
        return Optional.of(user.getId());
    }
}