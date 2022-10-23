package ch6;

import java.util.Scanner;

public class Ch6_Q18_CheckPassword {
    public static boolean hasAtleastEightCharacters(String password) {
        return password.length() > 8;
    }

    public static boolean isPasswordAlphaNumeric(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasAtleastTwoDigits(String password) {
        int cnt = 0;
        for (int i = 0; i < password.length(); i++) {
            cnt = Character.isDigit(password.charAt(i)) ? cnt + 1 : cnt;
            if (cnt >= 2)
                return true;
        }
        return false;
    }

    public static boolean checkPassword(String password) {
        return hasAtleastEightCharacters(password) &&
                hasAtleastTwoDigits(password) &&
                isPasswordAlphaNumeric(password);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(checkPassword(sc.next()));
    }
}
