package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——懒汉模式——枚举（线程安全，推荐）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 14:07
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public enum Student7 {
    INSTANCE;


    //可以天然的防反射攻击，防序列化与反序列化破坏
    public static Student7 getInstance() {
        return INSTANCE;
    }
}
