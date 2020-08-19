package com.lock;

import javax.swing.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁实验
 */
public class GetHoldCount {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println(lock.getHoldCount());
        lock.lock();

        System.out.println(lock.getHoldCount());
        lock.lock();

        System.out.println(lock.getHoldCount());
        lock.lock();

        System.out.println(lock.getHoldCount());
        lock.unlock();

        System.out.println(lock.getHoldCount());
        lock.unlock();

        System.out.println(lock.getHoldCount());
        lock.unlock();

        System.out.println(lock.getHoldCount());
    }
}
