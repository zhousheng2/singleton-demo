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
public class Student10 {
    // 1、私有构造器
    private Student10(){}

    // 2、原子类集合
    private static final AtomicReference<Student10> students = new AtomicReference<Student10>();

    // 3、通过内部类名获取属性
    public static final Student10 getInstance() {
        for (; ; ) {
            Student10 student = students.get();
            if (student != null) {
                return student;
            }
            student = new Student10();
            if (students.compareAndSet(null,student)) {
                return student;
            }
        }
    }

    // 验证
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Student10.getInstance().hashCode());
            }).start();
        }
    }
}
