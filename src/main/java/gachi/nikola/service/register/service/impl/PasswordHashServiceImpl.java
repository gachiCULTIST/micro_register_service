package gachi.nikola.service.register.service.impl;

import gachi.nikola.service.register.service.PasswordHashService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class PasswordHashServiceImpl implements PasswordHashService {

    @Override
    public String hash(String password, String salt) {
        String stringForHash = password + salt;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            for (int i = 0; i < 3; ++i) {
                byte[] hashBytes = digest.digest(stringForHash.getBytes(StandardCharsets.UTF_8));
                stringForHash = byteToString(hashBytes);
            }

            return stringForHash;
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    private String byteToString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
