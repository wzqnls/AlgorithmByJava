package com.minimumspantrees;

import java.util.Vector;

public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {
    /**
     * 节点数
     */
    private int n;
    /**
     * 边数
     */
    private int m;
    /**
     * 是否为有向图
     */
    private boolean directed;
    /**
     * 具体节点数据
     */
    private Vector<Edge<Weight>>[] g;

    public SparseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        /**
         * g初始化为一个空vector
         */
        g = (Vector<Edge<Weight>>[])new Vector[n];
        for(int i = 0 ; i < n ; i ++) {
            g[i] = new Vector<Edge<Weight>>();
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
    public void addEdge(Edge e) {
        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;

        /**
         * 由于邻接表，查找是否有重边需要遍历整个链表
         */
        g[e.v()].add(new Edge(e));
        if (e.v() != e.w() && !directed) {
            g[e.w()].add(new Edge(e.w(), e.v(), e.wt()));
        }
        m++;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex" + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                Edge e = g[i].elementAt(j);
                System.out.print("( to:" + e.other(i) + ",wt:" + ")\t");
            }
            System.out.println();
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i).other(v) == w) {
                return true;
            }
        }
        return false;
    }

    // 返回图中一个顶点所有邻边
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
