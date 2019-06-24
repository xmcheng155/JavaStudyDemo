package com.study.spring.pattern.singleton;

/**
 * 静态内部类实现单列模式（性能及安全都可以保证）
 */
public class LazySingletonTow {
    private LazySingletonTow(){}
    public static LazySingletonTow getInstance(){
        return LazySingletonHolder.singletonTow;
    }

    private static class LazySingletonHolder{
        private static final LazySingletonTow singletonTow = new LazySingletonTow();
    }
}
