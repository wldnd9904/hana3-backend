package com.study.ex21_logger;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LogTest extends Ex21LoggerApplicationTests {
    static int count = 0;

    @Test
    public void TestLogger() {
        Class myClass = LogTest.class;
        // 클래스객체 - 클래스에 대한 정보 가짐
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.trace("trace logging: {}", count++);
        logger.debug("debug logging: {}", count++);
        logger.warn("warn logging: {}", count++);
        logger.info("info logging: {}", count++);
        logger.error("error logging: {}", count++);
    }

    @Test
    public void testSlf4j() {
        log.trace("trace logging: {}", count++);
        log.debug("debug logging: {}", count++);
        log.warn("warn logging: {}", count++);
        log.info("info logging: {}", count++);
        log.error("error logging: {}", count++);

    }
}
