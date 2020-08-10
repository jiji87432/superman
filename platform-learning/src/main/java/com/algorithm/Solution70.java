package com.algorithm;

/**
 * @author zhangyongji
 * @since 2020/7/17.
 * https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 时间 O(n)
 * 空间 O(1)
 * dp[n]=dp[n−1]+dp[n−2]
 */
public class Solution70 {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return Math.max(1, n);
        }
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        /**
         * 1 1 1
         * 1 2
         * 2 1
         */
        System.out.println(climbStairs(3));
    }

}
