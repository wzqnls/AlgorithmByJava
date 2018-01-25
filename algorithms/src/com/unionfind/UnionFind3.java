package com.unionfind;

/**
 * @author lishuo
 * 对每个链表的size进行优化
 */
public class UnionFind3 {

    /**
     * parent[i]表示当前元素所指向的父节点
     * sz[i]表示以i为根的集合中元素的个数
     * count表示节点个数
     */
    private int[] parent;
    private int[] sz;
    private int count;

    public UnionFind3(int count) {
        parent = new int[count];
        sz = new int[count];
        this.count = count;

        for (int i = 0; i < count; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p) {
        assert p >= 0 && p < count;
        while(p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        /**
         * 合并两个集合，将元素少的合并到元素多的集合上
         */
        if(sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }


}
