package com.example.singletondemo.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Despriction: 单例模式——懒汉模式——CAS（乐观锁）实现（线程安全）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student8 {
    // 1、私有构造器
    private Student8(){}

    // 2、原子类集合
    private static final AtomicReference<Student8> students = new AtomicReference<Student8>();

    // 3、通过内部类名获取属性
    public static final Student8 getInstance() {
        for (; ; ) {
            Student8 student = students.get();
            if (student != null) {
                return student;
            }
            student = new Student8();
            if (students.compareAndSet(null,student)) {
                return student;
            }
        }
    }
}
