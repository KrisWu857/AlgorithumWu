package com.class100;

// KMP算法模版
// 测试链接 : https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/

public class Code01_KMP {

    public static int strStr(String s1 , String s2) {
    //    return s1.indexOf(s2);
        return kmp(s1.toCharArray() , s2.toCharArray()) ;
    }

    public static int kmp(char[] s1, char[] s2) {
        // s1中当前比对的位置是x
        // s2中当前比对的位置是y
        int n = s1.length, m = s2.length, x = 0, y = 0;
        // O(m)
        int[] next = nextArray(s2, m);
        while (x < n && y < m) {
            if (s1[x] == s2[y]) {
                x++;
                y++;
            } else if (y == 0) {  // s2彻底配不出来了,只能选择让s1下一个位置
                x++;
            } else {
                y = next[y];
            }
        }
        return y == m ? x - y : -1;
    }

    //得到next数组
    public static int[] nextArray(char[] s , int m ) {
        if (m == 1 ) {
            return new int[] {-1};
        }
        //  建立next数组
        int[] next = new int[m];
        next[0] = -1 ;
        next[1] = 0 ;
        // i表示当前要求next值的位置
        // cn表示要和前一个字符比对的下标
        int i = 2 , cn = 0;
        while (i < m ) {
            if (s[i - 1 ] == s[cn]) {  // 前一个位置的
                next[i++] = ++cn ;
            } else if (cn > 0) {  // 也就是意味着还能往前蹦
                cn = next[cn] ;
            } else {
                // 来到-1,还是没有相匹配的,只能为0了
                next[i++] = 0 ;
            }
        }
        return next;
    }

}
