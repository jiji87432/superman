package com.jvm;

/**
 * -XX:MetaspaceSize=50m -XX:MaxMetaspaceSize=50m
 * <p>
 * java.lang.OutOfMemoryError: Metaspace 错误的主要原因, 是加载到内存中的 class 数量太多或者体积太大
 */
public class JvmMetaspaceCase {
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String[] args) throws Exception {
        for (int i = 0; ; i++) {
            Class c = cp.makeClass("com.jvm" + i).toClass();
        }
    }
}