package com.study.ex23_scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Ex23SchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ex23SchedulerApplication.class, args);
    }

}
