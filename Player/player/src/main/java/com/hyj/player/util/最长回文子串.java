package com.hyj.player.util;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：最长回文子串
 * @Date：2024/1/30 9:09
 */
public class 最长回文子串 {
    public static void main(String[] args) {
//        String ababcba = longestPalindrome2("bbbbbb");

        System.out.println("123456789".substring(0,5));
    }

    private static String longestPalindrome2(String s){
        if (s.length()==1){
            return s;
        }
        int start=0;
        int end=0;
        for (int i = 1; i < s.length(); i++) {
            //奇数个
            int length1 = length(s, i, i);
            //偶数个
            int length2 = length(s, i, i + 1);

            int len=Math.max(length1,length2);
            //asdsa
            if (len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }

        }
        return s.substring(start,end+1);
    }

    private static int length(String s,int right,int left){
        while (right>=0&&left<s.length()&&s.charAt(right)==s.charAt(left)){
            right--;
            left++;
        }

        return left-right-1;
    }

    //第一次
    private static String longestPalindrome1(String s){
        if (s.length()==1){
            return s;
        }
        char[] chars = s.toCharArray();
        String str="";
        char[] chars1=new char[chars.length];
        char[] chars2=new char[chars.length];
        boolean b1=true;
        boolean b2=true;
        int a=0;
        for (int i = 0; i < chars.length; i++) {
            while ((i-a>=0&&i+a<chars.length)){
                //bbbbbb
                //asdfghkla
                //aacabdkacaa
                if (b1&&(i>=1&&i+a<chars.length)&&chars[i-a]==chars[i+a]){
                    //aba这种情况
                    chars1[i]=chars[i];
                    chars1[i-a]=chars[i-a];
                    chars1[i+a]=chars[i+a];
                }else {
                    b1=false;
                }
                if (b2&&i+a+1<chars.length&&chars[i-a]==chars[i+a+1]){
                    //xczvabba这种情况
                    chars2[i-a]=chars[i-a];
                    chars2[i+a+1]=chars[i+a+1];
                }else {
                    b2=false;
                }
                a++;
            }
            if (String.valueOf(chars1).trim().length()>=str.length()){
                str=String.valueOf(chars1).trim();
            }
            if (String.valueOf(chars2).trim().length()>=str.length()){
                str=String.valueOf(chars2).trim();
            }
            chars1=new char[chars.length];
            chars2=new char[chars.length];
            b1=true;
            b2=true;
            a=0;
        }
        return str;
    }
}
