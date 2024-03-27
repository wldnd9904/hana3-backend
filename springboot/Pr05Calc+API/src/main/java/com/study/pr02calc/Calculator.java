package com.study.pr02calc;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Calculator {
    private int inputA;
    private int inputB;
    private String result = "0";

    public void add(int a, int b) {
        inputA = a;
        inputB = b;
        result = String.valueOf(a + b);
    }

    public void sub(int a, int b) {
        inputA = a;
        inputB = b;
        result = String.valueOf(a - b);
    }

    public void mul(int a, int b) {
        inputA = a;
        inputB = b;
        result = String.valueOf(a * b);
    }

    public void div(int a, int b) {
        inputA = a;
        inputB = b;
        result = String.valueOf((double) a / (double) b);
    }
}
