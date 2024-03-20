package com.hyj.player.thread;

import java.util.concurrent.*;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：Excutes
 * @Date：2024/3/14 15:34
 */
public class Excutes {

    static class Runnabletest implements Runnable{

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
//        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(2);
//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
//          2,
//          3,
//          0,
//          TimeUnit.MILLISECONDS,
//                queue,
//                r -> new Thread(),
//                new ThreadPoolExecutor.AbortPolicy()
//        );
//        Runnabletest runnabletest=new Runnabletest();
//        threadPoolExecutor.submit(runnabletest);
////        System.out.println(Runtime.getRuntime().availableProcessors());
//        System.out.println(Integer.MAX_VALUE);

        String key="123"+"";
        System.out.println(key);
    }

}
