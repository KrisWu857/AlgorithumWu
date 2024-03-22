package com.class101;

// 最短循环节的长度
// 给你一个字符串s，它一定是由某个循环节不断自我连接形成的
// 题目保证至少重复2次，但是最后一个循环节不一定完整
// 现在想知道s的最短循环节是多长
// 测试链接 : https://www.luogu.com.cn/problem/P4391
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过

import java.io.*;

public class Code01_RepeatMinimumLength {
    public static int MAXN = 1000001;

    public static int n ;

    public static int[] next = new int[MAXN];

    public static char[] s ;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.valueOf(in.readLine());
        s = in.readLine().toCharArray();
        out.println(compute());
        out.flush();
        out.close();
        in.close();
    }

    public static int compute() {
        nextArray();
        return n - next[n];
    }
    // next数组的建立

    public static void nextArray() {
        // 前两个位置的value值固定为: -1 , 0
        next[0] = -1 ;
        next[1] =  0 ;
        int i = 2 , cn = 0 ; // 从2开始
        while ( i <= n ) { // 不越界
            if (s[i - 1 ] == s[cn]) { //前一个位置的
                next[i++] = ++cn ;
            } else if (cn > 0 ) {
                cn = next[cn];
            } else {
                next[i++] = 0 ;
            }
        }
    }
}
