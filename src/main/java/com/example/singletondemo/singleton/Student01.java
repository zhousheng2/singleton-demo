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
public class Student01 {

    // 1、私有静态成员变量进行初始化
    private static final Student01 student = new Student01();

    // 2、私有构造器
    private Student01(){};

    // 3、对外提供公有静态方法:直接返回已初始化的对象
    public static Student01 getInstance() {
        return student;
    }

    // 验证
    public static void main(String[] args) {
        Student01 s1 = Student01.getInstance();
        Student01 s2 = Student01.getInstance();
        System.out.println(s1 == s2);
    }
}
