package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock必须手动释放锁
 */
public class MustUnLock {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {
            //
            System.out.println(Thread.currentThread().getName() + "-run");
        } finally {
            lock.unlock();
        }
    }
}