package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——懒汉模式——同步锁（代码块）（通常线程安全，低概率不安全）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student05 {

    // 1、私有静态成员变量进行初始化
    private static Student05 student;

    // 2、私有构造器
    private Student05(){
    }

    // 3、同步代码快方式，锁力度减小，但是低概率依然不安全
    public static Student05 getInstance() {
        if (student == null) {
            synchronized (Student05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                student = new Student05();
            }
        }
        return student;
    }

    // 验证
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Student05.getInstance().hashCode());
            }).start();
        }
    }
}
