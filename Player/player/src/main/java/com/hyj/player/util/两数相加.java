package com.hyj.player.util;

import java.util.Scanner;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：两数相加
 * @Date：2024/1/25 11:13
 */
public class 两数相加 {

    public static void main(String[] args) {
        System.out.print("l1 =  ");
        String l1 = new Scanner(System.in).nextLine();
        System.out.print("l2 =  ");
        Scanner l2=new Scanner(System.in);
        ListNode listNode1 = intArray(l1);
        ListNode listNode2 = intArray(l2.next());
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode.toString());
    }



    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode=new ListNode(0);
        int c=0;
        ListNode next = listNode;
        while (l1!=null||l2!=null){
            int x= l1!=null?l1.val:0;
            int y= l2!=null?l2.val:0;

            int value=x+y+c;
            c=value/10;
            value=value%10;
            next.next=new ListNode(value);
            next=next.next;
            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
        }
        if (c==1){
            next.next=new ListNode(c);
        }
        return listNode.next;
    }

    private static ListNode intArray(String l1){
        String[] l1split = l1.trim().replace("[","").replace("]","").
                replace(" ","").split(",");
        int[]array=new int[l1split.length];
        for (int i = 0; i < array.length; i++) {
            try {
                int i1 = Integer.parseInt(l1split[i]);
                array[i]=i1;
            }catch (Exception e){
                System.out.println(l1split[i]+"转换为数字失败");
            }
        }
        if (array.length<1){
            return null;
        }
        //首节点
        ListNode listNode=new ListNode(array[0]);
        ListNode nextNode;
        nextNode=listNode;
        for (int i = 1; i < array.length; i++) {
            nextNode.next= new ListNode(array[i]);
            nextNode=nextNode.next;
        }
        nextNode=listNode;
//        System.out.println("nextNode:"+nextNode.toString());
//        ListNode Listnode = new ListNode(0);    //创建首节点，节点的val是0.
//        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
//        nextNode=Listnode;                      //指向首节点，这样两个结点的指针指向同一个结点
//
////创建链表
//        for(int i=1;i<10;i++){
//            ListNode node = new ListNode(i);  //生成新的节点
//            nextNode.next=node;               //把新节点连起来
//            nextNode=nextNode.next;           //当前节点往后移动
//        }       //当for循环完成之后 nextNode指向最后一个节点，

        return nextNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
