package com.study.spring.pattern.proxy.staticproxy;

import com.study.spring.pattern.proxy.Person;
import com.study.spring.pattern.proxy.Woman;

public class StaticProxyBuy extends Person{

    private Person person;

    public StaticProxyBuy(Person person) {
        this.person = person;
    }

    public void buySomeThing() {
        System.out.println("我是代购，你要买什么?");
        person.buySomeThing();
        System.out.println("你现在有"+person.getMoney());
        System.out.println("购买成功");
    }
}
