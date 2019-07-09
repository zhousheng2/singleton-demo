package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——懒汉模式——静态内部类（线程安全，推荐）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student6 {
    // 1、私有构造器
    private Student6(){}

    // 2、私有静态内部类
    private static class StudentFactory {
        private static Student6 student = new Student6();
    }

    // 3、通过内部类名获取属性
    public static Student6 getInstance() {
        return StudentFactory.student;
    }
}
