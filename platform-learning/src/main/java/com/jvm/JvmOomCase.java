package com.jvm;

/**
 * 配置JVM参数: -Xmx12m
 * <p>
 * java.lang.OutOfMemoryError: Java heap space
 * <p>
 * 这两个区域的最大内存大小, 由JVM启动参数 -Xmx 和 -XX:MaxPermSize 指定. 如果没有明确指定,
 * 则根据平台类型(OS版本+ JVM版本)和物理内存的大小来确定。假如在创建新的对象时, 堆内存中的空间
 * 不足以存放新创建的对象, 就会引发java.lang.OutOfMemoryError: Java heap space 错误。不管
 * 机器上还没有空闲的物理内存, 只要堆内存使用量达到最大内存限制,就会抛出 java.lang.OutOfMemoryError: Java heap space 错误。
 */
public class JvmOomCase {
    static final int SIZE = 2 * 1024 * 1024;

    public static void main(String[] a) {
        int[] i = new int[SIZE];
    }
}