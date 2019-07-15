package com.study.spring.pattern.observer;

import java.lang.reflect.Method;
import java.util.Date;

public class Event {
    private Date date;

    //目标类
    private Object targetObject;

    //目标方法
    private Method targetMethod;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
