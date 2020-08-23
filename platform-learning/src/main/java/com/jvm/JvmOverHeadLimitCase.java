package com.jvm;

import java.util.Map;
import java.util.Random;

/**
 * 配置JVM参数: -Xmx12m
 * <p>
 * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 * <p>
 * 注意, java.lang.OutOfMemoryError: GC overhead limit exceeded
 * 错误只在连续多次 GC 都只回收了不到2%的极端情况下才会抛出。假如不抛出 GC overhead limit
 * 错误会发生什么情况呢?那就是GC清理的这么点内存很快会再次填满, 迫使GC再次执行. 这样就形成恶性循环,
 * CPU使用率一直是100%, 而GC却没有任何成果. 系统用户就会看到系统卡死 - 以前只需要几毫秒的操作, 现在需要好几分钟才能完成。
 */
public class JvmOverHeadLimitCase {
    public static void main(String args[]) throws Exception {
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "value");
        }
    }
}