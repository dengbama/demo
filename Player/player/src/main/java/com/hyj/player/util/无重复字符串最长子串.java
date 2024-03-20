package com.hyj.player.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：无重复字符串最长子串
 * @Date：2024/1/26 9:08
 */
public class 无重复字符串最长子串 {

    public static void main(String[] args) {
        String s="abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    private static int lengthOfLongestSubstring(String s){
        if (s.length()==0){
            return 0;
        }
        Map<Character, Integer>map=new HashMap<>();
        int max=0;
        //下标
        int index=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //有重复出现的情况
            if (map.containsKey(c)){
                //上一次出现的下标
                Integer integer = map.get(c);
                index= Math.max(integer + 1, index);
            }
            max=Math.max(max,i-index+1);

            //最大值已经大于剩余长度的情况下就不用循环了
            if (max>s.length()-i){
                break;
            }

            map.put(c,i);

        }
        return max;
    }

}
