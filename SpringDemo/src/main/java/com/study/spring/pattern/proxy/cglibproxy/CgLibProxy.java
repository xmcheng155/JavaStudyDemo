package com.study.spring.pattern.proxy.cglibproxy;

import com.study.spring.pattern.proxy.Person;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibProxy implements MethodInterceptor {

    private Person person;

    public Person getInstance(Person person){
        this.person = person;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(this);
        return (Person)enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是代购，你要买什么?");
        System.out.println("你有"+person.getMoney()+"元");
        methodProxy.invoke(person,objects);
        System.out.println("购买成功");
        return null;
    }
}
