package com.hyj.player.config;

import com.hyj.player.entity.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：Exc
 * @Date：2024/3/15 9:05
 */
@Configuration
public class Exc {
    private static LinkedBlockingQueue<Runnable> linkedBlockingQueue=new LinkedBlockingQueue<>(20);
    private static ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
            10,
            20,
            1000,
            TimeUnit.MILLISECONDS,
            linkedBlockingQueue,
            r -> new Thread(),
            new ThreadPoolExecutor.AbortPolicy()
    );


    public FutureTask<String> exc(Task task) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(task);
        threadPoolExecutor.submit(futureTask);
        threadPoolExecutor.shutdown();
        futureTask.get();
        return futureTask;
    }

}
