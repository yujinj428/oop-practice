package org.example;

import org.example.password.RandomPasswordGenerator;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {
        // as-is
        // 내부에서 생성하는 경우: 강결합 => 기존 RandomPasswordGenerator 에 의존하지 않게 한다 => import 하지 않고 결합을 느슨하게 한다
        RandomPasswordGenerator randomPwdGen = new RandomPasswordGenerator();

        String password = passwordGenerator.generatePassword();
        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
