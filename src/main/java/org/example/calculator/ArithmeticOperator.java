package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum ArithmeticOperator {
    ADDITION("+") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    // enum에 넘겨질 parameter
    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    // 외부에 노출되는 Public interface
    public static int calculate(int operand1, String operator, int operand2) {
        // values() static methods getting all cases as enum type list
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())
                .filter(v -> v.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙 연산 기호가 아님"));
        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }

    public String getOperator() {
        return operator;
    }

    // 각 enum에 구현할 메서드를 abstract로 선언
    public abstract int arithmeticCalculate(final int operand1, final int operand2);
}
