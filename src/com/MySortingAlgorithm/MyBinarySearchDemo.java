package com.MySortingAlgorithm;

public class MyBinarySearchDemo {
    public static void main(String[] args) {
        // 定义一个数组
        int [] arr = {1,2,3,4,5,6,7,8,9};
        //  确定需要查询的数字
        int number = 8  ;
        int index  = biarySearchForIndex(arr,number);
        System.out.println(index);
    }

    private static int biarySearchForIndex(int[] arr, int number) {
        // 找到左指针和右指针所在位置,mid就是二者的中间值
        int  min = 0;
        int max = arr.length-1 ;
        while(min <= max){
           int  mid = (min + max ) /2 ;
           if (arr[mid] > number){   // 目标值在中间值的左边, 那么最大值就要发生变化,变成  max =  mid - 1
               max = mid - 1 ;
           }else if(arr[mid] < number){   // 目标值在中间值的右边,那么最小值就要发生变化,变成min  = mid + 1
               min = mid +  1 ;

           }else{   //  目标值恰巧等于中间值,直接返回结果
               return mid ;
           }
        }
        return -1 ;
    }
}
