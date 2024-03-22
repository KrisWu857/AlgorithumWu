package com.itkriswu.com;

public class Test{
    public static void main(String[] args) {
        // 目标:学习一个抽象类的基本使用,  做父类,被继承
        GoldCard   c = new GoldCard();
        c.setMoney(10000);
        c.setUser("吴俊毅");
        c.pay(300);
        System.out.println("剩余"+c.getMoney());
        c.pay(c.getMoney());

    }
}
