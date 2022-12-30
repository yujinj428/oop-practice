package org.example;

import org.example.password.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
/*
경계 조건 테스트 필수
*/
public class PasswordValidatorTest {

    @DisplayName("비밀번호가 8자리 이상 12자리 이하이면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest() {
        assertThatCode(()-> PasswordValidator.validate("admin123@"))
                .doesNotThrowAnyException();
    }

    // cmd + n 메서드 생성
    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @ParameterizedTest  // https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests
    @ValueSource(strings = {"abcdefg", "abcdefghiklmn"})  // 경계값
    void validatePasswordTest2(String password) {
        assertThatCode(() -> PasswordValidator.validate("admin"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자리 이상 최대 12자리 이하여야 한다.");
    }
}
