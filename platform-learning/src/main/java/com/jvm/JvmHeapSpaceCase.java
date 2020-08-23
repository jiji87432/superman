package com.jvm;

import javassist.ClassPool;

/**
 * -Xmx200M -XX:MaxPermSize=16M
 * <p>
 * java.lang.OutOfMemoryError: PermGen space 的主要原因, 是加载到内存中的 class 数量太多或体积太大。
 */
public class JvmHeapSpaceCase {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100_000_000; i++) {
            generate("eu.plumbr.demo.Generated" + i);
        }
    }

    public static Class generate(String name) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        return pool.makeClass(name).toClass();
    }
}