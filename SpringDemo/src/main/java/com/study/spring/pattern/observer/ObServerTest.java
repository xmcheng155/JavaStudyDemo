package com.study.spring.pattern.observer;

public class ObServerTest {
    public static void main(String[] args) {
        SubjectDataBase subjectDataBase = new SubjectDataBase();
        subjectDataBase.selectSql("select * from adt.inpatient where 1=2");
    }
}
