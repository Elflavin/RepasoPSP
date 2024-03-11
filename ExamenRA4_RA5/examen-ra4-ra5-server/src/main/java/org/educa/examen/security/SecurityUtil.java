package org.educa.examen.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
@Slf4j
public class SecurityUtil implements PasswordEncoder {

    private static final String SEED = "CLAVE_DE_CIFRADO_DE_32_BITS_A256";
    private static final String CRYPT = "AES";
    private static final String CRYPT_ONE = "SHA-512";


    // TODO: Implementar crypt
    public String crypt(String message) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SEED.getBytes(),CRYPT);
        Cipher cipher = Cipher.getInstance(CRYPT);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // TODO: Implementar decrypt
    public String decrypt(String encryptedMessage){
        SecretKeySpec secretKeySpec = new SecretKeySpec(SEED.getBytes(),CRYPT);
        Cipher cipher = null;
        byte[] decryptedBytes;
        try {
            cipher = Cipher.getInstance(CRYPT);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new String(decryptedBytes);
    }

    // TODO: Implementar createHash
    public String createHash(String message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(CRYPT_ONE);
        byte[] hashBytes = digest.digest(message.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }


    @Override
    public String encode(CharSequence rawPassword) {
        try {
            return createHash(rawPassword.toString());
        } catch (Exception e) {
            log.error("Exception encode: ", e);
        }
        return null;

    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        boolean find = false;
        try {
            if (encode(rawPassword).equals(encodedPassword)) {
                find = true;
            }
        } catch (Exception e) {
            log.error("Exception encode: ", e);
        }
        return find;
    }
}
