package com.class25;


// 堆结构和堆排序，acm练习风格
// 测试链接 : https://www.luogu.com.cn/problem/P1177
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
public class Code01_HeapSort {

    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static int  n ;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0 ; i < n  ;i++) {
            in.nextToken();
            arr[i] = (int)in.nval;
        }
        // heapify1()
    }

    // i位置的数，向上调整大根堆
    public static void  heapInsert(int i) {
        while (arr[i] > arr[(i - 1) / 2 ]) {
            swap( i , (i - 1 ) / 2 );
            i = (i - 1 ) / 2 ;
        }
    }


    // i位置的数，向下调整大根堆
    // 当前堆的大小为size
    public static void heapify(int i , int size ) {
        int l = i * 2 + 1 ;
        while (l < size) {
            // 有左孩子
            // 右孩子: l + 1
            // 评选最强的孩子,是哪个下标的孩子
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l ;
            // 上面已经评选出最强的孩子了,接下来,要用当前的数和这个最强的孩子进行对比,看最强孩子是谁
            best = arr[best] > arr[i] ? best : i ;
            if (best == i) { // 如果发现最强的孩子等于自己的话,就不需要往下对调
                break;
            }
            swap(best , i );
            i = best ;
            l = i * 2 + 1 ;
        }
    }

    public static void swap(int i , int  j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 从顶到底建立大根堆，O(n * logn)
    // 依次弹出堆内最大值并排好序，O(n * logn)
    // 整体时间复杂度O(n * logn)
    public static void heapsort1() {
        for (int i = 0 ; i < n ; i++) {
            heapInsert(i); // 建大根堆
        }
        int size = n ;
        while (size > 1 ) {  // size == 0 说明排序结束
            swap(0 , --size);// 把最后一个下标和0位置的数交换,并把最大的数给扣掉,也即--size
            heapify(0 ,size);
        }
    }
    // 从底到顶建立大根堆，O(n)
    // 依次弹出堆内最大值并排好序，O(n * logn)
    // 整体时间复杂度O(n * logn)
    public static void heapsort2() {
        for (int i = n -1 ; i > 0 ; i--) {
            heapify(i , n);
        }
        int size = n ;
        while (size > 1 ) {
            swap(0 , --size);
            heapify(0 ,size);
        }
    }
}
