package com.deng.util;

import java.io.IOException;

/**
 * @Author：dengwenxin-wb
 * @Project：filedeal
 * @name：JvmStudy
 * @Date：2024/2/6 11:40
 */
public class JvmStudy {

    public static void main(String[] args) throws IOException {
        System.out.println("A");
        new JvmStudy();
        new JvmStudy();
    }

    public JvmStudy(){
        System.out.println("B");
    }

    {
        System.out.println("C");
    }

    static {
        System.out.println("D");
    }

//    public static void main(String[] args) {
//        new B02();
//        System.out.println(B02.a);
//    }
//
//    static class A02{
//        static int a=0;
//        static {
//            a=1;
//        }
//    }
//
//    static class B02 extends A02{
//        {
//            a=2;
//        }
//    }
}
