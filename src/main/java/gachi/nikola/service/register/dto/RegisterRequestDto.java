package gachi.nikola.service.register.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterRequestDto {

    private final String login;
    private final String email;
    private final String password;
}
