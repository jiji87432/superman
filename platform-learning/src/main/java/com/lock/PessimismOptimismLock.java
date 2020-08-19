package com.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class PessimismOptimismLock {
    public static void main(String[] args) {
        // 内部是乐观锁，也是安全的
        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.incrementAndGet();
        System.out.println("===:" + i);
    }
}