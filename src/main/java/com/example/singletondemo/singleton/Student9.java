package com.example.singletondemo.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Despriction: 单例模式——懒汉模式——ThreadLocal实现（线程安全）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student9 {
    // 1、私有构造器
    private Student9(){}

    // 2、线程类
    private static final ThreadLocal<Student9> local = new ThreadLocal<Student9>() {
        @Override
        protected Student9 initialValue() {
            return new Student9 ();
        }
    };

    // 3、通过内部类名获取属性
    public static final Student9 getInstance() {
        return local.get();
    }
}
