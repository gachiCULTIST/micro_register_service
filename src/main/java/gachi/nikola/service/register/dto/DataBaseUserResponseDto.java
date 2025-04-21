package gachi.nikola.service.register.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DataBaseUserResponseDto {

    private long id;
    private UUID uuid;
    private String login;
    private String email;
    private String passwordHash;
    private String salt;
}
