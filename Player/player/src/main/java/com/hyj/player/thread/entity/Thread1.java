package com.hyj.player.thread.entity;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：Thread1
 * @Date：2024/1/30 14:47
 */
public class Thread1 extends Thread {

    private String log;

    public Thread1(String log) {
        System.out.println("th1111");
        this.log = log;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        System.out.println(log);
    }

}
