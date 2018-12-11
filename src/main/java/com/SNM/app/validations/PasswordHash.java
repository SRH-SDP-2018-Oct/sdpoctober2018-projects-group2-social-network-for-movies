package com.SNM.app.validations;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash {

    public String HashPassword(String passwordToHash)

    {
        String generatedPassword = null;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(passwordToHash.getBytes());
            byte[] bytes = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
            //System.out.println("Hash Pw:   "+generatedPassword);
        }
        catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        return generatedPassword;
    }
}
