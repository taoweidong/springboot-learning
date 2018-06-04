package com.taowd.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TestTask
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/4 23:33
 * @Version V1.0
 */
@Component
public class TestTask {

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 每隔三秒执行此方法
     */
//    @Scheduled(fixedRate = 3000)
    @Scheduled(cron = "")
    public void reportCurrentTime() {
        System.out.println("当前时间：" + dataFormat.format(new Date()));
    }
}
