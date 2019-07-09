package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——饿汉模式（线程安全，推荐）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 10:05
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student1 {
    // 1、私有构造器
    private Student1(){};

    // 2、私有静态成员变量进行初始化
    private static Student1 student = new Student1();

    // 3、对外提供公有静态方法:直接返回已初始化的对象
    public static Student1 getInstance() {
        return student;
    }

}
