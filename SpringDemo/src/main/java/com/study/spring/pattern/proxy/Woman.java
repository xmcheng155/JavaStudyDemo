package com.study.spring.pattern.proxy;

public class Woman extends Person{
    private int money =0;

    public Woman(int money) {
        this.money = money;
    }
    public int getMoney() {
        return money;
    }
    public void buySomeThing() {
        System.out.println("我要买香水");
    }
}
