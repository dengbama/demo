package com.hyj.player.thread;



/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：TestClassLoader
 * @Date：2024/2/18 14:33
 */
public class TestClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("自定义加载器");
        return loadClass(name, true);
    }
}
