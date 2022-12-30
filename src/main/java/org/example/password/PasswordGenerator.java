package org.example.password;

/**
 인터페이스 사용 => 테스트 하기 쉬움, 결합도 낮음
 FunctionalInterface 람다로 구현할 수 있다
 */

@FunctionalInterface
public interface PasswordGenerator {
    String generatePassword();
}
