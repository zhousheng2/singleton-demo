package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——懒汉模式——普通（线程不安全）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student2 {
    // 1、私有构造器
    private Student2(){}

    // 2、私有静态成员变量进行初始化
    private static Student2 student = null;

    // 3、对外提供公有静态方法：若初始化对象为空，则new一个返回；若不为空，则直接返回对象。但是，此模式存在线程安全隐患，请看Student3
    public static Student2 getInstance() {
        if (student == null) {
            student = new Student2();
        }
        return student;
    }
}
