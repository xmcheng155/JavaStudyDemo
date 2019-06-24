package com.study.spring.pattern.singleton;


/**
 * 懒汉式加载 会有线程问题出现
 */
public class LazySingletonOne {
    private LazySingletonOne(){}
    private static LazySingletonOne one = null;
    public static LazySingletonOne getInstance(){
        if(one==null){
            one = new LazySingletonOne();
        }
        return one;
    }
}
