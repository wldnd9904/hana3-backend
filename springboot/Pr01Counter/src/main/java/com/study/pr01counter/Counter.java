package com.study.pr01counter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor
public class Counter {
    private int count;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }
}
