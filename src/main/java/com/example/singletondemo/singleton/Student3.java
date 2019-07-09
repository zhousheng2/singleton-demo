package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——懒汉模式——同步锁（线程安全，效率低）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student3 {
    // 1、私有构造器
    private Student3(){}

    // 2、私有静态成员变量进行初始化
    private static Student3 student = null;

    // 3、对外提供公有静态方法：若初始化对象为空，则new一个返回；若不为空，则直接返回对象。虽然此模式线程安全，但是效率低下
    public static synchronized Student3 getInstance() {
        if (student == null) {
            student = new Student3();
        }
        return student;
    }
}
