package com.study.spring.pattern.observer;

public class SubjectDataBase extends EventListerner{

    public void selectSql(String sql){
        System.out.println("查询数据库");
        printLog(sql);
    }

    public void deleteSql(String sql){
        System.out.println("删除数据库");
        printLog(sql);
    }
}
