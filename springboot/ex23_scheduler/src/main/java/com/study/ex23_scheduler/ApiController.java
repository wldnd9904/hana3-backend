package com.study.ex23_scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ApiController {
    @Autowired
    RestTemplate restTemplate;

    @Scheduled(fixedRate = 1000)
    public void task1() throws InterruptedException {
        log.info("FixedRate Text - {}", System.currentTimeMillis() / 1000);
        String url = "http://localhost:8080/api/batch-job";
        ResponseEntity response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.getBody());
    }

    @GetMapping("/api/batch-job")
    public String batchJson() {
        return "batch-job response";
    }
}
