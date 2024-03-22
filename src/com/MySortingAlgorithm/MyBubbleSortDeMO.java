package com.MySortingAlgorithm;

public class MyBubbleSortDeMO {
    //  冒泡排序的算法实现  时间复杂度为0(N^2)
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 1,9,8,6,7,15,10};
        bubbleSort(arr);
    }

    private static  void bubbleSort(int[] arr){
        //外层循环控制的是次数,比数组长度少一次
        for (int i = 0; i < arr.length-1; i++) {
            //内层循环就是实际循环你比较
            // -1 是为了不让数组越界
           // -i是 每一轮结束之后,就可以少比较一个元素
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]  = arr[j+1];
                    arr[j+1] = temp ;
                }
            }
        }
        printArr(arr);
    }
    //打印排序之后的数组
    private static  void printArr(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+ "");
        }
       System.out.println();
    }
}
