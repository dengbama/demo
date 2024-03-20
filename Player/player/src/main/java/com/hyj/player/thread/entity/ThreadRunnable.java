package com.hyj.player.thread.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：ThreadTest
 * @Date：2024/1/30 15:41
 */
public class ThreadRunnable implements Runnable {

    private int tickets=1;

    private Lock lock=new ReentrantLock();

    @Override
    public synchronized void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        while (true){
            if (tickets<=100){
                System.out.println(Thread.currentThread().getName()+"正在抢"+(tickets)+"张票");
                tickets++;
            }else {
                break;
            }
        }

//        lock.lock();
//        try {
//
//        }catch (Exception e){
//
//        }finally {
//            lock.unlock();
//        }


    }


}
