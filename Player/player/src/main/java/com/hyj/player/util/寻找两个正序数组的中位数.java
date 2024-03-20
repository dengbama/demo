package com.hyj.player.util;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：寻找两个正序数组的中位数
 * @Date：2024/1/29 15:58
 */
public class 寻找两个正序数组的中位数 {

    /*
    * 示例 1：

        输入：nums1 = [1,3], nums2 = [2]
        输出：2.00000
        解释：合并数组 = [1,2,3] ，中位数 2
        示例 2：

        输入：nums1 = [1,2], nums2 = [3,4]
        输出：2.50000
        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

       * [1,9,10]  [1,2,3]
       *
    *1234  5678
    * */

    public static void main(String[] args) {

        double deal = deal(new int[]{1, 9, 10}, new int[]{1, 2, 3});
    }

    private static double deal(int[] nums1,int[] nums2){
        int len = nums1.length + nums2.length;
        int[]all=new int[len];
        int zhongjian=len/2;
        //特殊情况
        //nums1最大值小于nums2最小值
        if (nums1[nums1.length-1]<nums2[0]){
            if (len%2==0){
                if (nums2.length>zhongjian){
                    return (nums2[zhongjian-nums1.length]+nums2[zhongjian-nums1.length+1])/2.0;
                }else if (nums2.length==zhongjian){
                    return (nums2[0]+nums2[nums1.length-1])/2.0;
                }else {
                    return (nums1[nums1.length-(zhongjian-nums2.length)]+nums1[nums1.length-(zhongjian-nums2.length)+1])/2.0;
                }
            }else {

            }
        }

        //nums1最小值大于nums2最大值
        if (nums1[0]>nums2[nums2.length-1]){

        }

        return 0;
    }

}
