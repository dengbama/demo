package com.deng.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @Author：dengwenxin-wb
 * @Project：filedeal
 * @name：Test1
 * @Date：2024/2/4 15:27
 */
public class Test1 {
    public static void main(String[] args) {
//        //分配空间
        allocateCompare();
//        //读写速度
        operateCompare();
        Test1 test1=new Test1();
        test1=null;
        System.gc();//手动垃圾回收

        maxMemory();

    }

    

    //最大内存
    private static void maxMemory(){
        System.out.print("最大内存:");
        System.out.println(
                Runtime.getRuntime().maxMemory()/1024.0/1024.0+"M"
        );
        System.out.print("空闲内存：");
        System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024.0+"M");
    }

    @Override
    protected void finalize()throws Throwable{
        System.out.println(
                "gc垃圾回收之前调用的方法"
        );
    }


    //分配空间比较
    private static void allocateCompare(){
        int time=10000000;
        long directSt=System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            ByteBuffer byteBuffer=ByteBuffer.allocateDirect(2);
        }
        long directEnd=System.currentTimeMillis();
        System.out.println("在进行" + time + "次分配操作时，直接内存：分配耗时:" + (directEnd - directSt) + "ms");
        System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024.0+"M");
        long st = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            ByteBuffer byteBuffer=ByteBuffer.allocate(2);
        }
        long end = System.currentTimeMillis();
        System.out.println("在进行" + time + "次分配操作时，堆内存：分配耗时:" + (end - st) + "ms");
    }

    //堆内存读写和直接读写速度区别
    private static void operateCompare(){
        int time = 1000000000;
        ByteBuffer byteBuffer1=ByteBuffer.allocate(2*time);
        long st=System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            byteBuffer1.putChar('a');
        }
        byteBuffer1.flip();
        for (int i = 0; i < time; i++) {
            byteBuffer1.getChar();
        }
        long end = System.currentTimeMillis();
        System.out.println("在进行" + time + "次分配操作时，堆内存：读写耗时:" + (end - st) + "ms");
        System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024.0+"M");
        ByteBuffer byteBuffer2=ByteBuffer.allocateDirect(2*time);
        long direcSt=System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            byteBuffer2.putChar('a');
        }
        byteBuffer2.flip();
        for (int i = 0; i < time; i++) {
            byteBuffer2.get();
        }
        long direcEnd = System.currentTimeMillis();
        System.out.println("在进行" + time + "次分配操作时，直接内存：读写耗时:" + (direcEnd - direcSt) + "ms");
    }
}
