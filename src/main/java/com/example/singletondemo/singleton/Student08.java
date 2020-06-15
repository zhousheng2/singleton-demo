package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——懒汉模式——静态内部类（线程安全，强烈推荐）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student08 {

    // 1、私有构造器
    private Student08(){}

    // 2、私有静态内部类
    private static class StudentFactory {
        private static final Student08 student = new Student08();
    }

    // 3、通过内部类名获取属性
    public static Student08 getInstance() {
        return StudentFactory.student;
    }

    // 验证
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Student08.getInstance().hashCode());
            }).start();
        }
    }
}
