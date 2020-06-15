package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——饿汉模式变种（线程安全，推荐，同前面一种）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 10:05
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student02 {

    // 1、私有静态成员变量进行初始化
    private static Student02 student;

    // 2、私有构造器
    private Student02(){
    };

    // 3、静态代码块
    static {
        student = new Student02();
    }

    // 3、对外提供公有静态方法:直接返回已初始化的对象
    public static Student02 getInstance() {
        return student;
    }

    // 验证
    public static void main(String[] args) {
        Student02 s1 = Student02.getInstance();
        Student02 s2 = Student02.getInstance();
        System.out.println(s1 == s2);
    }
}
