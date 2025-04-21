package gachi.nikola.service.register.service;

public interface PasswordHashService {

    String hash(String password, String salt);
}
