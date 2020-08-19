package com.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 模拟插队策略：非公平锁的情况下，读锁仅在队列头结点不是想获取写锁的情况下可以插队
 */
public class ReadWriteNoFairBargeLock {

    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    private static void read() {
        System.out.println(Thread.currentThread().getName() + "尝试获取读锁");
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "====获取了读锁,读取中====");
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了读锁");
            readLock.unlock();
        }
    }

    private static void wirte() {
        System.out.println(Thread.currentThread().getName() + "尝试获取写锁");
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "====获取了写锁,写入中====");
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> wirte(), "Thread1").start();
        new Thread(() -> read(), "Thread2").start();
        new Thread(() -> read(), "Thread3").start();
        new Thread(() -> wirte(), "Thread4").start();
        new Thread(() -> read(), "Thread5").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread[] thread = new Thread[1000];
                for (int i = 0; i < thread.length; i++) {
                    thread[i] = new Thread(() -> read(), "子线程创建的Thread" + i);
                }
                for (int i = 0; i < thread.length; i++) {
                    thread[i].start();
                }
            }
        }).start();
    }
}
