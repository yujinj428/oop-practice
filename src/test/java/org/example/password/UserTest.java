package org.example.password;

import org.example.password.User;
import org.example.password.WrongFixedPasswordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() {
        // given
        User user = new User();
        // when
        //user.initPassword();
        //user.initPassword(new CorrectFixedPasswordGenerator());
        user.initPassword(()->"abcde123");
        //then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        // given
        User user = new User();
        // when
        //user.initPassword();
        user.initPassword(new WrongFixedPasswordGenerator());
        //then
        assertThat(user.getPassword()).isNull();
    }
}