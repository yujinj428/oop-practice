package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CourseTest {
    @DisplayName("과목을 생성한다. ")
    @Test
    void createTest() {
        // 객체가 예외없이 잘 생성 되었는지 테스트할 때 assertThatCode 사용
        assertThatCode(() -> new Course("OOP", 3, "A+"))
                .doesNotThrowAnyException();


    }
}
