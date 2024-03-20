package com.hyj.player.thread;

import com.hyj.player.thread.entity.Thread1;
import com.hyj.player.thread.entity.Thread2;
import com.hyj.player.thread.entity.ThreadRunnable;
import org.junit.runners.model.TestClass;

import java.lang.ref.SoftReference;
import java.net.URLClassLoader;
import java.sql.DriverManager;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：ThreadTest
 * @Date：2024/1/29 17:28
 */
public class ThreadTest {

    static Object object=new Object();

    static boolean bool=false;

    public static void main(String[] args)  {
        //按顺序打印2，1

        //打印1
        Thread thread=new Thread(
                ()->{
                    synchronized (object){
                        while (!bool){
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(1);
                    }
                }
        );

        Thread thread1=new Thread(
                ()->{
                    synchronized (object){
                        System.out.println(2);
                        bool=true;
                        object.notify();
                    }
                }
        );
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {


        }
        thread1.start();
    }

}
