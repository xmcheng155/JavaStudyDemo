package com.study.spring.pattern.proxy;

public abstract class Person {
    private int money;

    public int getMoney() {
        return money;
    }
    public abstract void buySomeThing();
}
