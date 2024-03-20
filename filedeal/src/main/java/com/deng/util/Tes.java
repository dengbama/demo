package com.deng.util;

/**
 * @Author：dengwenxin-wb
 * @Project：filedeal
 * @name：Tes
 * @Date：2024/2/7 16:11
 */
public class Tes {

    public static void main(String[] args) {
        Tes_A[]tes_as=new Tes_A[10];
    }

    static class Tes_A{
        static {
            System.out.println("tes_A初始化了");
        }
    }
}
