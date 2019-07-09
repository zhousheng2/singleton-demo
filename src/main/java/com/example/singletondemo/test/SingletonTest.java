package com.example.singletondemo.test;

import com.example.singletondemo.pojo.Student;
import com.example.singletondemo.singleton.*;

/**
 * @Despriction: TODO
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 14:56
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class SingletonTest {

    public static void main(String[] args) {
        // 饿汉式
        System.out.println(Student0.getInstance());
        System.out.println(Student1.getInstance());
        // 懒汉式
        System.out.println(Student2.getInstance());
        System.out.println(Student3.getInstance());
        System.out.println(Student4.getInstance());
        System.out.println(Student5.getInstance());
        System.out.println(Student6.getInstance());
        System.out.println(Student7.getInstance());
        System.out.println(Student8.getInstance());
        System.out.println(Student9.getInstance());
        Student10.registerService("abc", new Student());
        System.out.println(Student10.getInstance("abc"));
    }
}
