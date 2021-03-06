package com.graphbasics;

import java.util.Vector;

/**
 * @author lishuo
 * 稀疏图 -- 邻接表
 */
public class SparseGraph implements Graph{
    private int n;
    private int m;
    private boolean directed;
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        /**
         * g初始化为n个为空的vector
         * 表示每个g[i]都为空
         */
        this.g = (Vector<Integer>[]) new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<Integer>();
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i) == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);
        if (v != w && !directed) {
            g[w].add(v);
        }
        m++;
    }

    // 返回图中一个顶点所有邻边
    // 由于java引用机制，返回一个Vector不会带来额外开销
    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("Vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                System.out.print(g[i].elementAt(j) + "\t");
            }
            System.out.println();
        }
    }
}
