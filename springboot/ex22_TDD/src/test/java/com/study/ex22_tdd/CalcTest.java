package com.study.ex22_tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
    static Calc calc;

    @BeforeAll
    static void init() {
        calc = new Calc();
    }

    @Test
    @DisplayName("add 테스트")
    void add() {
        assertEquals(12, calc.add(10, 2));
    }

    @Test
    @DisplayName("sub 테스트")
    void sub() {
    }

    @Test
    @DisplayName("mul 테스트")
    void mul() {
    }

    @Test
    @DisplayName("div 테스트")
    void div() {
    }
}