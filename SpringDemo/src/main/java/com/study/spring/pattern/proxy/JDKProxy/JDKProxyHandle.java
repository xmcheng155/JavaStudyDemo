package com.study.spring.pattern.proxy.JDKProxy;

import com.study.spring.pattern.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxyHandle implements InvocationHandler{

    private Person person;

    public JDKProxyHandle(Person person) {
        this.person = person;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是代购，你要买什么?");
        method.invoke(this.person,args);
       // System.out.println("你现在有"+person.getMoney());
        System.out.println("购买成功");
        return null;
    }
}
