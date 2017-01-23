package com.drivers.manager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by xhuji on 2016/9/7.
 */
@Slf4j
@Service
public class SchedulingService {

//    @Scheduled(cron="*/5 * * * * MON-FRI")
//    public void schedule(){
//        log.info("测试调度");
//    }

//    /**
//     * 每隔50秒调度一次
//     */
//    @Scheduled(fixedDelay=50000)
//    public void schedule2(){
//        log.info("测试调度2");
//    }
//
//    /**
//     * 暂定一秒后，每隔50秒调度一次
//     */
//    @Scheduled(initialDelay=1000, fixedRate=50000)
//    public void schedule3(){
//        log.info("测试调度3");
//    }
}
