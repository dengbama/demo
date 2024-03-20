package com.hyj.player.thread;


import java.security.Guard;
import java.security.GuardedObject;
import java.sql.SQLOutput;
import java.util.*;


/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：ThreadTestUtil
 * @Date：2024/2/26 14:25
 */
public class ThreadTestUtil {

    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> vector=new Vector<>();
        vector.add(1);
        Hashtable<String, String>hashtable=new Hashtable<>();
        hashtable.put("","");
        Cj cj=new Cj();
        Runnable callable1=() -> {
            for (int i = 0; i < 10000; i++) {
                cj.insert();
            }
        };
        Runnable callable2=() -> {
            for (int i = 0; i < 10000; i++) {
                cj.delet();
            }
        };
        Thread thread1=new Thread(callable1,"callable1");
        Thread thread2=new Thread(callable2,"callable2");
//        GuardedObject guardedObject=new GuardedObject();
//        Object object = guardedObject.getObject();

        new Thread(()-> System.out.println(1)).start();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(cj.getvalue());
        Set<Integer>set=new HashSet<>();
        Iterator<Integer> iterator = set.iterator();
        iterator.hasNext();
    }

    static class Cj{

        private Integer a=0;

        public synchronized void insert(){
            a++;
        }

        public synchronized void  delet(){
            a--;
        }

        public Integer getvalue(){
            return a;
        }
    }

}
