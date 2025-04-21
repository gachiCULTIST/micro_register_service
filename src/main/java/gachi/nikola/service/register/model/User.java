package gachi.nikola.service.register.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

    private final String login;
    private final String email;
    private String passwordHash;
    private String salt;
}
