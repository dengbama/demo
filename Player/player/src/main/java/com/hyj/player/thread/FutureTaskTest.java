package com.hyj.player.thread;

import sun.security.provider.certpath.PKIXTimestampParameters;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：FutureTaskTest
 * @Date：2024/2/22 10:36
 */
public class FutureTaskTest {

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
//        System.out.println(Arrays.toString(args));
        ClassLoader.getSystemClassLoader().loadClass("");
        FutureTask<Integer> task= new FutureTask<>(() -> {
            System.out.println(111);
            Thread.sleep(5000);
            System.out.println(11111111);
            return 100;
        }
        );
        Thread thread=new Thread(task,"futureTask");
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(12);
        System.out.println(222222);
        thread.interrupt();
        System.out.println(3333);
//        Integer integer = task.get();
//        System.out.println("integer:"+integer);
//        thread.setPriority(10);
//        String str="111aaaaa";
//        Thread thread1=new Thread(() ->
//                System.out.println(str)
//            );
//        thread1.start();

    }

}
