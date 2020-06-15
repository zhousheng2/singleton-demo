package com.example.singletondemo.singleton;

/**
 * @Despriction: 单例模式——枚举（线程安全，最完美推荐）：不仅可以实现线程同步，还可以天然的防反射攻击，防序列化与反序列化破坏
 * @Author: zhousheng
 * @CreatedTime: 2019-07-09 14:07
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public enum Student09 {
    INSTANCE;

    // 验证
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Student09.INSTANCE.hashCode());
            }).start();
        }
    }
}
