/*package com.itkriswu.com.Test2;

import java.util.Random;

public class RandomNumberHandlerDemo {
    public static void main(String[] args) {
        RandomNumberHandler(new RandomNumberHandler() {
            @Override
            public int getnumber() {
                Random r = new Random();
                int num = r.nextInt(10)+1;
                return  num;
            }
        });
    }
    public static void RandomNumberHandler(RandomNumberHandler randomNumberHandler){
        int result =  randomNumberHandler.getnumber();
        System.out.println(result);

 useRandomNumberHandler(() -> {
            Random r = new Random();
            int num = r.nextInt(10)+1;
            return  num;
            //如果Lambda所操作的接口的方法有返回值的话,一定要用return返回结果值,否则的话会编译报错
        });

    }
}
interface   RandomNumberHandler{
    int  getnumber();

}
*/