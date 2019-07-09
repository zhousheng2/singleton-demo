package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——懒汉模式——双重检查（通常线程安全，低概率不安全）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student4 {
    // 1、私有构造器
    private Student4(){}

    // 2、私有静态成员变量进行初始化
    private static Student4 student = null;

    /**
     *
     * 似乎解决了之前提到的问题，将synchronized关键字加在了内部，也就是说当调用的时候是不需要加锁的，只有在student为null，并创建对象的时候才需要加锁，性能有一定的提升。
     * 但是，这样的情况，还是有可能有问题的，看下面的情况：
     * 	在Java指令中创建对象和赋值操作是分开进行的，也就是说student = new Student4();语句是分两步执行的。
     *  但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Student4实例分配空间，然后直接赋值给student成员，然后再去初始化这个Student4实例。
     *  这样就可能出错了，我们以A、B两个线程为例：
     *
     * 		a>A、B线程同时进入了第一个if判断
     *
     * 		b>A首先进入synchronized块，由于student为null，所以它执行student = new Student4();
     *
     * 		c>由于JVM内部的优化机制（指令重排序），JVM先画出了一些分配给Student4实例的空白内存，并赋值给student 成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。
     *
     * 		d>B进入synchronized块，由于student 此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。
     *
     * 		e>此时B线程打算使用Student4实例，却发现它没有被初始化，于是错误发生了（空指针）如：student.getName()。
     *
     * 	所以程序还是有可能发生错误，其实程序在运行过程是很复杂的，从这点我们就可以看出，尤其是在写多线程环境下的程序更有难度，有挑战性。
     *  我们对该程序做进一步优化：
     *
     */
    public static Student4 getInstance() {
        if (student == null) {
            synchronized (Student4.class) {
                if (student == null) {
                    student = new Student4();
                }
            }
        }
        return student;
    }
}
