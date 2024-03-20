package com.hyj.player.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：RecentLock
 * @Date：2024/3/6 9:23
 */
public class RecentLock {

    private static ReentrantLock reentrantLock=new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        reentrantLock.lockInterruptibly();
        try {


        }finally {
            reentrantLock.unlock();
        }
        Condition condition = reentrantLock.newCondition();

        Thread thread=new Thread(
                ()->{
                    try {
                        boolean b = reentrantLock.tryLock(2000, TimeUnit.MICROSECONDS);
                        if (b){

                        }

                    }catch (Exception e){

                    }
                }
        );
    }


}
