package com.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock避免死锁
 */
public class TryLockDeadLock implements Runnable {
    int flag = 1;

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        TryLockDeadLock tryLockDeadLock1 = new TryLockDeadLock();
        TryLockDeadLock tryLockDeadLock2 = new TryLockDeadLock();
        tryLockDeadLock1.flag = 1;
        tryLockDeadLock2.flag = 0;
        new Thread(tryLockDeadLock1).start();
        new Thread(tryLockDeadLock2).start();
    }

    @Override
    public void run() {
        if (flag == 1) {
            try {
                for (int i = 0; i < 100; i++) {
                    if (lock1.tryLock(800, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println("1获取了lock1");
                            Thread.sleep(new Random().nextInt(1000));
                            // 获取第二把锁
                            if (lock2.tryLock(800, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println("1获取了lock2");
                                    System.out.println("1成功获取两把锁");
                                    break;
                                } finally {
                                    lock2.unlock();
                                    Thread.sleep(new Random().nextInt(1000));
                                }
                            } else {
                                System.out.println("1获取lock2失败,在重试");
                            }
                        } finally {
                            // 因为上面获取到了锁，需要释放
                            lock1.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    } else {
                        System.out.println("1获取lock1失败,在重试");
                    }
                }
            } catch (Exception e) {
                // 防止800ms内被中断
                e.printStackTrace();
            }
        }

        if (flag == 0) {
            try {
                for (int i = 0; i < 100; i++) {
                    if (lock2.tryLock(3000, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println("2获取了lock2");
                            Thread.sleep(new Random().nextInt(1000));
                            // 获取第二把锁
                            if (lock1.tryLock(800, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println("2获取了lock1");
                                    System.out.println("2成功获取两把锁");
                                    break;
                                } finally {
                                    lock1.unlock();
                                    Thread.sleep(new Random().nextInt(1000));
                                }
                            } else {
                                System.out.println("2获取lock1失败,在重试");
                            }
                        } finally {
                            // 因为上面获取到了锁，需要释放
                            lock2.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    } else {
                        System.out.println("2获取lock2失败,在重试");
                    }
                }
            } catch (Exception e) {
                // 防止800ms内被中断
                e.printStackTrace();
            }
        }
    }
}