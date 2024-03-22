package com.myFactorial;

public class MyFactorDemo1 {
    public static void main(String[] args) {
        int sum = getsum(500);
        System.out.println(sum);
    }
    private  static  int getsum(int i){
        /*
        把大的问题拆成小的问题, 1~100的和就是 100和1~99只见那的和;
                                        99 + 1~98之间的和;
         */
        if (i ==1 ){
            return 1;
        }else{
            return i + getsum(i-1);
        }
    }

}
