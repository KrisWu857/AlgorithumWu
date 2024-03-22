package com.class23;

// 随机快速排序，acm练习风格
// 测试链接 : https://www.nowcoder.com/practice/3385982ae71d4a1ca8bf3d03614c0325
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过

import java.io.*;

public class Code01_QuickSort {

    public static int MAXN = 1001;

    public static int[] arr = new int[MAXN];

    public static int n ;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            quickSort2(0, n - 1);
            out.print(arr[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    // 随机快速排序经典版(不推荐)
    public static void quickSort1(int l, int r ) {
        if (l >= r ) {
            return;
        }
        // 随机这一下，常数时间比较大
        // 但只有这一下随机，才能在概率上把快速排序的时间复杂度收敛到O(n * logn)
        // l...r上随机选一个位置,x这个值来做划分
        //(r - l + 1) : l...r的长度 s
        //(int) (Math.random() * (r - l + 1) : 0 1 2 3 ... s -1
        //l + (int) (Math.random() * (r - l + 1)) 这一句的解释
        //eg :  5  6 7 8
        //      l      r
        //   r - l + 1 :  4
        // 0 1 2 3 ,再+上l的值5, 就是 5 ,6 ,7 ,8
        int x = arr[l + (int) (Math.random() * (r - l + 1))];
        int mid = partition1(l ,r ,x);
        quickSort1(l , mid -1);
        quickSort1(mid + 1 ,r );
    }

    // 已知arr[l....r]范围上一定有x这个值
    // 划分数组 <=x放左边，>x放右边，并且确保划分完成后<=x区域的最后一个数字是x
    public static int partition1(int l , int r ,int x ) {
        // a : arr[l...a-1] 范围是<=x的区域
        // xi : 记录在<=x的区域上任何一个x的位置，哪一个都可以
        int a  = l , xi = 0;
        for (int i = l ;i <= r;i++) {
            if (arr[i] <=x) {
                swap(a,i);
                if (arr[i] == x) {  // 这个if的作用就是拿来记录,把一个数换到小于等于x的区域的时候,记录一下他在哪个位置
                    xi = a ;
                }
                a++;
            }
        }
        swap(xi ,a - 1 );
        //a - 1的位置就是临街位置,左边都是小于等于的, 右边都是大于的
        return  a - 1 ;
    }


    public static void swap(int i ,int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // 随机快速排序改进版(推荐)
    public static void quickSort2(int l , int r  ){
        if (l >= r ) {
            return;
        }
        // 随机这一下，常数时间比较大
        // 但只有这一下随机，才能在概率上把快速排序的时间复杂度收敛到O(n * logn)
        int x = arr[l + (int) (Math.random() * r - l + 1)] ;
        partition2(l ,r ,x );
        // 为了防止底层的递归过程覆盖全局变量
        // 这里用临时变量记录first、last
        int left = first;
        int right = last ;
        quickSort2(l , left - 1);
        quickSort2(right + 1 , r);
    }

    // 荷兰国旗问题

    public static int first ,last ;

    // 已知arr[l....r]范围上一定有x这个值
    // 划分数组 <x放左边，==x放中间，>x放右边
    // 把全局变量first, last，更新成==x区域的左右边界

    public static void partition2(int l, int r , int x ) {
        first = l ;
        last = r;
        int i = l;
        while ( i <= last) {
            if (arr[i] == x ) {
                i++;
            }else if (arr[i] < x ) {
                swap(first++ , i++);
            }else {
                swap(i , last--);
            }
        }
    }
}
