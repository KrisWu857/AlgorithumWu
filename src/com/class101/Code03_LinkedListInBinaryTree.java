package com.class101;

// 二叉树中的链表
// 给你一棵以root为根的二叉树、一个以head为头的链表
// 在二叉树中，有很多一直向下的路径
// 如果某个路径上的数值等于以head为头的整个链表
// 返回True，否则返回False
// 测试链接 : https://leetcode.cn/problems/linked-list-in-binary-tree/

public class Code03_LinkedListInBinaryTree {

    public static int MAXN = 100001;
    public static int[] next = new int[MAXN];


    // 构建next数组
    public static void nextArray(int m ) {
        next[0] = -1 ;
        next[1] = 0 ;
        int i = 2 , cn = 0 ;
        while (i < m) {
            if (next[i - 1] == next[cn]) {
                next[i++] = ++cn ;
            } else if (cn > 0) {
                // 还能够继续往前面找
                cn = next[cn];
            }else {
                // 来到-1位置,还是没有找到相对应匹配的,值只能够为0了
                next[i++] = 0 ;
            }
        }
    }
}
