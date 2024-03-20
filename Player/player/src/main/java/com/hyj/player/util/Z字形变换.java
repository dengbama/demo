package com.hyj.player.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：Z字形变换
 * @Date：2024/1/31 11:05
 */
public class Z字形变换 {

    public static void main(String[] args) {
        String str="00000";
//        String substring = str.substring(0, -1);
//        System.out.println(substring);
    }

//    public static void main(String[] args) {
//        File file_test=new File("G:\\1\\2\\3\\4\\6\\5.txt");
//        List<String> list_test=new ArrayList<>();
//        while (!file_test.getParentFile().exists()){
//            String name = file_test.getName();
//            list_test.add(name);
//            file_test=file_test.getParentFile();
//        }
//        for (int i = 0; i < list_test.size(); i++) {
//            file_test.mkdir();
//            file_test=new File(file_test.getAbsolutePath()+File.separator+list_test.get(list_test.size()-i-1));
//        }
//        try {
//            file_test.createNewFile();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    /*
    * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
                P   A   H   N
                A P L S I I G
                Y   I   R
    * */

//    public static void main(String[] args) {
//        String convert = convert("PAYPALISHIRING", 4);
//        System.out.println(convert);
//
//    }

    private static String convert(String s, int numRows){
        Map<Integer, String>map=new HashMap<>();
        //1行是特殊情况
        if (numRows==1){
            return s;
        }
        //还需要一个数来判断是往下放还是斜着放
        int judge=2*numRows-2;
        for (int i = 0; i < s.length(); i++) {
            int yy;
            if (judge==0){
                judge=2*numRows-2;
            }else {
                judge--;
            }
            //余数作为key
            //大于2说明是斜着放的
            if (numRows-judge>=2){
                //反着斜放
                yy=numRows-(i%numRows+1);
            }else {
                yy=i%(numRows);
            }
            if (map.containsKey(yy)){
                String sb = map.get(yy);
                sb=sb+ s.charAt(i);
                map.put(yy,sb);
            }else {
                String sb=String.valueOf(s.charAt(i));
                map.put(yy,sb);
            }

        }

        StringBuilder sb= new StringBuilder("");
        for (int i = 0; i < numRows; i++) {
            if (map.containsKey(i)){
                sb.append(map.get(i));
            }
        }
        return sb.toString();
    }
}
