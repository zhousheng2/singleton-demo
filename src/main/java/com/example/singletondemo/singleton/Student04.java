package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——懒汉模式(懒加载)——同步锁（线程安全，效率低）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student04 {

    // 1、私有静态成员变量进行初始化
    private static Student04 student;

    // 2、私有构造器
    private Student04(){
    }

    // 3、对外提供公有静态方法：若初始化对象为空，则new一个返回；若不为空，则直接返回对象。虽然此模式线程安全，但是效率低下
    public static synchronized Student04 getInstance() {
        if (student == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            student = new Student04();
        }
        return student;
    }

    // 验证
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Student04.getInstance().hashCode());
            }).start();
        }
    }
}
