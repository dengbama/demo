package com.hyj.player.thread.entity;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：TestSynchronized
 * @Date：2024/1/31 15:12
 */
public class TestSynchronized implements Runnable {



    //共享资源
    private static int i=0;

    public static synchronized void increase(String str){
//        System.out.println(str+"---"+i);
        i++;
    }

    public void increase1(String str){
//        System.out.println(str+"---"+i);
        i++;
    }

    @Override
    public  void run() {
        for(int j=0;j<1000000;j++){
            increase(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestSynchronized testSynchronized=new TestSynchronized();
        Thread thread1=new Thread(new TestSynchronized(),"线程1");
        Thread thread2=new Thread(testSynchronized,"线程2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
//        Thread.sleep(1);
        System.out.println(i);
    }

}
