package com.hyj.player.entity;

import org.springframework.context.annotation.Bean;

import java.util.concurrent.Callable;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：Task
 * @Date：2024/3/15 9:17
 */

public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "strtest";
    }
}
