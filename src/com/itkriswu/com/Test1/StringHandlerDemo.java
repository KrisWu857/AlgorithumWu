package com.itkriswu.com.Test1;

public class StringHandlerDemo {
    /*
     Lambda表达式带参数无表达式的方法
     */
    public static void main(String[] args) {
        useStringHandler(new StringHandler() {
            @Override
            public void printMessage(String msg) {
                System.out.println("我是匿名内部类"+msg);
            }
        });
  //lambda的实现
        useStringHandler((String msg) -> { System.out.println("我是Lambda表达式"+msg);} );
    }
    public static  void useStringHandler(StringHandler stringHandler){
        stringHandler.printMessage("kriswu");
    }
}

interface StringHandler{
    void  printMessage(String msg);
}
