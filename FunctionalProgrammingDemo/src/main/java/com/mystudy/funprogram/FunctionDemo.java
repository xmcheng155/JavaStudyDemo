package com.mystudy.funprogram;

import java.util.function.Function;

public class FunctionDemo {

    Function<String,Integer> integerStringFunction = (s)->{return Integer.valueOf(s);};
    public static void main(String[] args) {

        Function<String,Integer> integerStringFunction1 = s->{return Integer.valueOf(s);};
        Function<String,Integer> integerStringFunction2 = s->Integer.valueOf(s);
        System.out.println(integerStringFunction1.apply("1000")+10);
    }


}
