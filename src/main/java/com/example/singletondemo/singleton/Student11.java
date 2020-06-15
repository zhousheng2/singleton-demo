package com.example.singletondemo.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @Despriction: 单例模式——懒汉模式——容器实现（线程安全）
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 13:43
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class Student11 {
    // 1、私有构造器
    private Student11(){}

    // 2、Map容器
    private static Map<String,Object> maps = new HashMap<>();

    // 3、通过内部类名获取属性
    public static void registerService(String key, Object instance) {
        if (!maps.containsKey(key)) {
            maps.put(key, instance);
        }
    }

    public static Object getInstance(String key) {
        return maps.get(key);
    }
}
