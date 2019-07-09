package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——懒汉模式——双重检查锁（线程安全，效率有一定提升，推荐）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student5 {
    // 1、私有构造器
    private Student5(){}

    // 2、私有静态成员变量进行初始化，添加volatile关键字：1、保证内存可见性；2、禁止指令重排序
    private volatile static Student5 student = null;

    // 3、双重检查锁
    public static Student5 getInstance() {
        if (student == null) {
            synchronized (Student5.class) {
                if (student == null) {
                    student = new Student5();
                }
            }
        }
        return student;
    }
}
