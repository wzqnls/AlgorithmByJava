package com.graphbasics;

import java.util.Vector;

/**
 * @author lishuo
 * 稠密图 -- 邻接矩阵
 */
public class DenseGraph implements Graph{

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
    @Override
    public int V() {
        return n;
    }

    // 返回边数
    @Override
    public int E() {
        return m;
    }

    // 向图中添加边
    @Override
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

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<Integer>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]) {
                adjV.add(i);
            }
        }
        return adjV;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(g[i][j] + "\t");
            }
        }
    }
}
