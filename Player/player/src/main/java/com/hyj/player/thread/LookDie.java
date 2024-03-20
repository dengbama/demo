package com.hyj.player.thread;

import com.hyj.player.thread.entity.Thread1;
import com.sun.jnlp.JnlpLookupStub;

import java.util.HashMap;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：LookDie
 * @Date：2024/3/5 15:04
 */
public class LookDie {

    private static final String a="0";
    private static final String b="1";

    public static void main(String[] args) {


        Thread thread=new Thread(
                ()->{
                    synchronized (a){
                        System.out.println("aa");
                        try {
                            Thread.sleep(1000);
                            synchronized (b){
                                System.out.println("a---->b");
                            }
                        }catch (Exception e){
                        }
                    }
                }
        ,"aaa");

        Thread thread1=new Thread(
                ()->{
                    synchronized (b){
                        System.out.println("bb");
                        try {
                            Thread.sleep(500);
                            synchronized (a){
                                System.out.println("b---->a");
                            }
                        }catch (Exception e){

                        }
                    }
                }
        ,"bbb");
        thread.start();
        thread1.start();
        Object o=new Object();
        LockSupport.unpark(thread);

    }

}
