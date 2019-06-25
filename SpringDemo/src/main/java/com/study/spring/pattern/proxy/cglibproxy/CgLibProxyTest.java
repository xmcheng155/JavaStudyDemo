package com.study.spring.pattern.proxy.cglibproxy;

import com.study.spring.pattern.proxy.Person;
import com.study.spring.pattern.proxy.Woman;

public class CgLibProxyTest {
    public static void main(String[] args) {
        Person person = new Woman(20);
        CgLibProxy cgLibProxy = new CgLibProxy();
        Person person1 = cgLibProxy.getInstance(person);
        person1.buySomeThing();
    }
}
