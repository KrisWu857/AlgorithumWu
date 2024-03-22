package com.itkriswu.com;

public abstract class Card {
    private  String user;
    private  double money;

    /**
     *
      定义一个支付方法,表示卡片可以支付
     抽象方法
     */
    public abstract void pay(double money2) ;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
