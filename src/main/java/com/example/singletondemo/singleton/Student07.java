package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——懒汉模式——双重检查锁（线程安全，效率有一定提升，完美推荐）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student07 {
    // 1、私有构造器
    private Student07(){}

    // 2、私有静态成员变量进行初始化，添加volatile关键字：1、保证内存可见性；2、禁止指令重排序
    private volatile static Student07 student = null;

    // 3、双重检查锁
    public static Student07 getInstance() {
        if (student == null) {
            synchronized (Student07.class) {
                if (student == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    student = new Student07();
                }
            }
        }
        return student;
    }

    // 验证
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Student07.getInstance().hashCode());
            }).start();
        }
    }
}
