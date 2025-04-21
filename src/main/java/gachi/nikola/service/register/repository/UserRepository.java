package gachi.nikola.service.register.repository;

import gachi.nikola.service.register.model.User;

public interface UserRepository {

    void getUsersWithLoginOrEmail(String login, String email);

    void addUser(User user);
}
