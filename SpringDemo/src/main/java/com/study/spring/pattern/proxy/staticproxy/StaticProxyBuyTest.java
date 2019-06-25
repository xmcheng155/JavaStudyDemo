package com.study.spring.pattern.proxy.staticproxy;

import com.study.spring.pattern.proxy.Person;
import com.study.spring.pattern.proxy.Woman;

public class StaticProxyBuyTest {
    public static void main(String[] args) {
        Person person = new Woman(20);
        new StaticProxyBuy(person).buySomeThing();
    }
}
