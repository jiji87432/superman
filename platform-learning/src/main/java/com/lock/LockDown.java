package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDown {

    public static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    public static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
    public static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    private static void readDown() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到写锁，正在写入");
            Thread.sleep(1000);
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + "不释放写锁的情况下成功降级读锁，获取读锁成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放写锁");
        }
    }

    public static void main(String[] args) {
        new Thread(() -> readDown()).start();
    }
}
