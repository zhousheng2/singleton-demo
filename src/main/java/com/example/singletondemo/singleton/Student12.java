package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——懒汉模式——ThreadLocal实现（线程安全）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student12 {
    // 1、私有构造器
    private Student12(){}

    // 2、线程类
    private static final ThreadLocal<Student12> local = new ThreadLocal<Student12>() {
        @Override
        protected Student12 initialValue() {
            return new Student12();
        }
    };

    // 3、通过内部类名获取属性
    public static final Student12 getInstance() {
        return local.get();
    }

    // 验证
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Student12.getInstance().hashCode());
            }).start();
        }
    }
}
