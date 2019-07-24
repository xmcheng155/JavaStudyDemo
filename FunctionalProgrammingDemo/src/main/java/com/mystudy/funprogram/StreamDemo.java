package com.mystudy.funprogram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> lists = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream = lists.stream();
        stream.filter(n->(n%2==1)) //取奇数
                .limit(3)           // 只取三个
                .map(n-> n+10)      // 每个数字+10
                .sorted((a,b)-> {if(a>b)return -1; else return 1;})//倒序排序
                .forEach(System.out::println);//打印

    }
}
