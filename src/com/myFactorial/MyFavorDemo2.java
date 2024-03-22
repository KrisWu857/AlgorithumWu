package com.myFactorial;

public class MyFavorDemo2 {
    public static void main(String[] args) {
        System.out.println("");
        int result =  getJc(3 );
        System.out.println(result);
    }
    private  static  int getJc(int i ){
        // 一定要找到一个出口
        if (i ==1){
            return 1  ;
            //  递归的规则
        }else{
            return i + getJc(i-1);
        }

    }
}
