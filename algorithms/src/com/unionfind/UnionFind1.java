package com.unionfind;

/**
 * @author lishuo
 * 利用数组构建的并查集
 */
public class UnionFind1 {

    private int[] id;
    private int  count;

    public UnionFind1(int n) {
        count = n;
        id = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * 查找元素p所对应的编号
     * 时间复杂度为O(1)
     * @param p
     * @return
     */
    public int find(int p) {
        assert p >=0 && p < count;
        return id[p];
    }

    /**
     * 查看元素q和元素p是否在同一个集合
     * 时间复杂度为O(1)
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        // 合并过程需要遍历所有元素
        for (int i = 0; i < count; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
