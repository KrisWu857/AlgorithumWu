package com.itkriswu.com;

public class GoldCard extends  Card{
    @Override
    public void pay(double money2){
        System.out.println("您当前消费"+ money2);
        System.out.println("您当前卡片余额为"+getMoney());
        //优惠价
        double rs = money2 * 0.8;
        System.out.println("您实际支付:"+ rs);
        //更新账户余额
        setMoney(getMoney()-rs);

    }
}
