package com.graphbasics;

/**
 * @author lishuo
 * 稠密图 -- 邻接矩阵
 */
public class DenseGraph {

    // 节点数
    private int n;

    // 边数
    private int m;

    // 是否为有向图
    private boolean directed;

    // 图具体数据
    private boolean[][] g;


    public DenseGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;

        this.g = new boolean[n][n];
    }

    // 返回节点个数
    public int V() {
        return n;
    }

    // 返回边数
    public int E() {
        return m;
    }

    // 向图中添加边
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if (hasEdge(v, w)) {
            return;
        }

        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;


    }

    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }
}
