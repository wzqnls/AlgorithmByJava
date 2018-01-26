package com.unionfind;

public class UnionFind4 {

    // rank[i]代表以i为根的集合所表示的树的层数
    private int[] rank;

    // parent[i]表示第i个元素指向的父节点
    private int[] parent;

    private int count;

    public UnionFind4(int count) {
        parent = new int[count];
        this.count = count;
        rank = new int[count];
        // 初始化时，所有元素父节点指向自己，集合层数为1
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        assert p >= 0 && p < count;
        if(p != parent[p]) {
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

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        }
        else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        }
        else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
