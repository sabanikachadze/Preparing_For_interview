package org.example.DSA;

public class MaskEmail {

    public static String maskEmail(String email) {
        int at = (email == null) ? -1 : email.indexOf('@');
        if (at <= 0) throw new IllegalArgumentException();

        return email.charAt(0) + "*".repeat(at - 1) + email.substring(at);
    }

}
