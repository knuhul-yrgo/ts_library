package se.yrgo.libraryapp.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import javax.inject.Inject;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import se.yrgo.libraryapp.dao.UserDao;
import se.yrgo.libraryapp.entities.User;
import se.yrgo.libraryapp.entities.UserId;

public class UserService {
    private UserDao userDao;
    private PasswordEncoder encoder;

    @Inject
    UserService(UserDao userDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    public Optional<UserId> validate(String username, String password) {
        Optional<User> maybeUser = userDao.get(username);
//        if (maybeUser.isEmpty()) {
//            return Optional.empty();
//        }
        User user = maybeUser.get();
//        if (!encoder.matches(password, user.getPasswordHash())) {
//            return Optional.empty();
//        }
        return Optional.of(user.getId());
    }

    public boolean register(String name, String realname, String password) {
        String passwordHash = encoder.encode(password);

        // handle names like Ian O'Toole
        realname = realname.replace("'", "\\'");

        return userDao.persistUser(name, realname, passwordHash);
    }

    public boolean isNameAvailable(String name) {
        if (name == null || name.trim().length() < 3) {
            return false;
        }
        return userDao.userNotInDb(name);
    }
}