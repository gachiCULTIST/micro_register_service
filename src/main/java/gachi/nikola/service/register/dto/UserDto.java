package gachi.nikola.service.register.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto {

    private final String login;
    private final String email;
    private String passwordHash;
    private String salt;
}
