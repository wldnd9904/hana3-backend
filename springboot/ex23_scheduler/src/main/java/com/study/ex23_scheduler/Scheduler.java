package com.study.ex23_scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
@EnableAsync
public class Scheduler {

    @Async
    @Scheduled(fixedRate = 100)
    public void task1() throws InterruptedException {
        log.info("fixedRate task - {}", System.currentTimeMillis() / 1000);
        Thread.sleep(5000);
        System.out.println("dead");
    }

    @Scheduled(cron = "* * * * * * ")
    public void task3() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String strDate = sdf.format(now);
        log.info("cron task - {}", strDate);
    }


    //    @Async //해당 로직 시작되는 시간 기준 ms 간격으로 실행, 작업 완료까지 다음작업 안 됨
//    @Scheduled(fixedRate = 1000)
//    public void scheduleFixedRateTask() throws InterruptedException {
//        log.info("Fixed rate task - {}", System.currentTimeMillis());
//        Thread.sleep(5000);
//    }
}
