package com.utils;

import com.unionfind.UnionFind1;

public class UnionFindTest {

    public static void testUF1(int n) {
        UnionFind1 uf = new UnionFind1(n);

        long startTime = System.currentTimeMillis();

        // 进行n次操作，每次随机选择两个元素进行合并
        for (int i = 0; i < n; i++) {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            uf.unionElements(a, b);
        }

        // 再进行n次操作，每次随机选择连个元素，查询是否在同一集合
        for (int i = 0; i < n; i++) {
            int a= (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            uf.isConnected(a, b);
        }

        long endTime = System.currentTimeMillis();

        // 打印输出这2n个操作的耗时
        System.out.println("UF1: " + (endTime - startTime) + "ms");
    }
}
