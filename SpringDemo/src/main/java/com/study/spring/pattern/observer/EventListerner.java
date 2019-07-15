package com.study.spring.pattern.observer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class EventListerner {

    HashMap<Enum,List<Event>> hashMap = new HashMap<Enum, List<Event>>();

    public void addListerner(Enum eventType, Object target, Method method){

    }


}
