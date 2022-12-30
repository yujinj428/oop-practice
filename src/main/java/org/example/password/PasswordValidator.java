package org.example;

public class PasswordValidator {

    public static final String WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE = "비밀번호는 최소 8자리 이상 최대 12자리 이하여야 한다.";

    public static void validate(String s) {
        // cmd + alt + v 중복되는 코드를 대치
        int length = s.length();
        if (length < 8 || length > 12) {
            // cmd + alt + c constant 상수값 생성
            throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
        }
    }


}
