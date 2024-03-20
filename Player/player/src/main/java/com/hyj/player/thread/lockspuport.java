package com.hyj.player.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：lockspuport
 * @Date：2024/3/6 14:01
 */
public class lockspuport implements Callable<String> {

    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            LockSupport.park();
            System.out.println(3);
        });
        Thread thread1=new Thread(()->{
            LockSupport.park();
            System.out.println(2);
            LockSupport.unpark(thread);
        });
        Thread thread2=new Thread(()->{
                    System.out.println(1);
                    LockSupport.unpark(thread1);
        });
        thread.start();
        thread1.start();
        thread2.start();


    }

    @Override
    public String call() throws Exception {
        return null;
    }

    public  static void tets(){

    }
}
