package gachi.nikola.service.register.repository.impl;

import gachi.nikola.service.register.client.DataBaseClient;
import gachi.nikola.service.register.dto.UserDto;
import gachi.nikola.service.register.model.User;
import gachi.nikola.service.register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private DataBaseClient dataBaseClient;

    @Override
    public void getUsersWithLoginOrEmail(String login, String email) {

    }

    @Override
    public void addUser(User user) {
        UserDto userDto = new UserDto(user.getLogin(), user.getEmail())
                .setSalt(user.getSalt())
                .setPasswordHash(user.getPasswordHash());
        dataBaseClient.addUser(userDto);
    }
}
