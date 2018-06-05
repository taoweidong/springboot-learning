package com.taowd.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

/**
 * @ClassName AsyncTask
 * @Description 定义一个异步任务
 * @Author Taowd
 * @Date 2018/6/5 20:14
 * @Version V1.0
 */
@Component
public class AsyncTask {
    @Async
    public Future<Boolean> doTask1() throws InterruptedException {
        long start = System.currentTimeMillis();
        sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时：" + (end - start) + "毫秒");
        return new AsyncResult<Boolean>(true);
    }

    @Async
    public Future<Boolean> doTask2() throws Exception {
        long start = System.currentTimeMillis();
        sleep(700);
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask3() throws Exception {
        long start = System.currentTimeMillis();
        sleep(600);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }


}
