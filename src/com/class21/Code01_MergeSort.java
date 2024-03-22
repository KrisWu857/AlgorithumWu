package com.class21;
// 归并排序，acm练习风格
// 测试链接 : https://www.nowcoder.com/practice/bc25055fb97e4a0bb564cb4b214ffa92
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过

import java.io.*;

public class Code01_MergeSort {
    // 题目没有说数据量，按道理是要说的
    // 根据实验，长度500以内够用了
    // 如果有一天牛客升级了数据量导致出错
    // 把这个值改大即可

    public static int MAXN = 501;

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            // mergeSort1为递归方法
            // mergeSort2为非递归方法
            // 用哪个都可以
            // mergeSort1(0, n - 1);
            mergeSort2();
            out.print(arr[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    // 归并排序递归版
    // 假设l...r一共n个数
    // T(n) = 2 * T(n/2) + O(n)
    // a = 2, b = 2, c = 1
    // 根据master公式，时间复杂度O(n * logn)
    // 空间复杂度O(n)

    public static void mergeSort1(int l , int r ){
        if (l == r ) {
            return;
        }
        int m =  (l + r ) / 2 ;
        mergeSort1(l , m );
        mergeSort1(m +1 , r );
        merge(l , m ,r );
    }
    // 归并排序非递归版
    // 时间复杂度O(n * logn)
    // 空间复杂度O(n)

    public static void mergeSort2() {
        //一共发生O(logn)次
        for (int l ,m ,r ,step = 1 ; step < n ; step <<= 1 ) { //  step左移一位:  也就是 * 2
            // 内部分组为merge, 时间复杂度为O(n)
            l = 0 ;
            while (l < n) {
                m = l + step - 1 ;
                if ( m + 1 >= n ) {
                    // 已经没有右侧
                    break;
                }
                // 有右侧, 求右侧的右边界
                r = Math.min(l + (step << 1 ) - 1  , n - 1 ) ;  // 如果数组比较短,r就来到n - 1;
                // l  .... m m + 1 ... r
                //                      l.... m m + 1 ....r
                //                                         l.... m m + 1 ..... r
                merge(l , m , r );
                l = r + 1 ;
            }
        }
    }




    public static void merge(int l , int m ,int r ) {
        int i = 1 ;
        int a = 1 ;
        int b = m + 1 ;
        while (a <=m && b <=r) { // 左右侧都没有耗尽
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];  // 谁小拷贝谁
        }
        // 左侧指针, 右侧指针, 必有一个越界,一个不越界
        // 两个while循环只会命中其中一个
        while (a <= m ) {
            help[i++] = arr[a++];
        }
        while (b <= r ) {
            help[i++] = arr[b++];
        }

        //把help数组里的值刷到arr中
        for ( i = 1 ; i <= r ; i++) {
            arr[i] = help[i];
        }
    }
}
