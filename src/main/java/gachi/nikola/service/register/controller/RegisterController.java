package gachi.nikola.service.register.controller;

import gachi.nikola.service.register.dto.RegisterRequestDto;
import gachi.nikola.service.register.model.User;
import gachi.nikola.service.register.repository.UserRepository;
import gachi.nikola.service.register.service.PasswordHashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RegisterController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordHashService passwordHashService;

    @PostMapping("/register/api/v1/user")
    public void register(@RequestBody RegisterRequestDto requestDto) {
        if (requestDto.getLogin() == null || requestDto.getEmail() == null || requestDto.getPassword() == null) { // TODO: add normal validation
            throw new NullPointerException("Data is not completed");
        }

        String salt = UUID.randomUUID().toString();
        String passwordHash = passwordHashService.hash(requestDto.getPassword(), salt);

        User user = new User(requestDto.getLogin(), requestDto.getEmail())
                .setSalt(salt)
                .setPasswordHash(passwordHash);

        userRepository.addUser(user);
    }
}
