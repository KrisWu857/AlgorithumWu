package com.class66;

import java.util.Arrays;

// 斐波那契数
// 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列
// 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
// 也就是：F(0) = 0，F(1) = 1
// F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 给定 n ，请计算 F(n)
// 测试链接 : https://leetcode.cn/problems/fibonacci-number/
// 注意：最优解来自矩阵快速幂，时间复杂度可以做到O(log n)

public class Code01_FibonacciNumber {
    public static int fib1(int n){
        return f1(n);
    }
    public static int f1(int i ) {
        if (i ==0 ) {
            return  0;
        }
        if (i ==1 ) {
            return  1 ;
        }
        return f1(i -1 ) + f1(i - 2 );
    }


    // 自顶到低的动态规划 (记忆化搜索)
    public static int fib2(int n) {
        int[] dp = new int[n + 1 ];
        Arrays.fill(dp , -1 );
        return  f2(n , dp );
    }

    public static int f2(int i , int[] dp ) {  // 挂了一张缓存表,然后再展开 时间复杂度O(n)
        if ( i == 0 ) {
            return  0;
        }
        if (i == 1 ) {
            return  1 ;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = f2(i- 1 , dp ) + f2(i - 2  , dp);
        dp[i] = ans ;  //  展开的结果挂到缓存表里
        return  ans ;
    }

    // 从低到顶的动态规划 .
    public static int fib3(int n ) {
        if (n == 0 ) {
            return 0;
        }
        if ( n == 1 ) {
            return 1 ;
        }
        int[] dp = new int[n + 1 ];
        //dp[0] = 0
        dp[1] =1 ;
        for (int i = 2 ; i < n ; i++) {
            dp[i] = dp[i - 1 ] + dp[i - 2 ];
        }
        return dp[n];
    }

    // 利用有限的几个变量, 滚动更新, 节省一个辅助空间
    public static int fib4(int n ) {
        if ( n == 0 ) {
            return 0 ;
        }
        if ( n == 1 ) {
            return  1 ;
        }
        //  第一项结果0 ,  第二项
        int preLast = 0 , last = 1 ;
        for (int i = 2 ; i < n ; i++) {
            int cur = preLast + last ;
            preLast = last ;
            last = cur ;
        }
        return last ;
    }


}
