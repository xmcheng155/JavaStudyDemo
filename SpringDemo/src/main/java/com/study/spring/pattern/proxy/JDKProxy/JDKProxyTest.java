package com.study.spring.pattern.proxy.JDKProxy;

import com.study.spring.pattern.proxy.Person;
import com.study.spring.pattern.proxy.Woman;

import java.lang.reflect.Proxy;

public class JDKProxyTest {

    public static void main(String[] args) {
        Person person = new Woman(20);

        Person person1 = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),new Class[]{Person.class},new JDKProxyHandle(person));
        person1.buySomeThing();
    }
}
