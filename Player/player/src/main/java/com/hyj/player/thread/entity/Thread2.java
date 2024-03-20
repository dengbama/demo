package com.hyj.player.thread.entity;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：Thread2
 * @Date：2024/1/30 14:51
 */
public class Thread2 implements Runnable {

    private String log;

    public Thread2(String log) {
        this.log = log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(log);
    }
}
