package com.minimumspantrees;

import java.util.Vector;

public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph{
    private int n;
    private int m;
    private boolean directed;
    private Edge<Weight>[][] g;

    public DenseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        /**
         * g初始化为n*n的布尔矩阵
         * 每个g[i][j]均为null;
         */
        g = new Edge[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = null;
            }
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

        if (hasEdge(e.v(), e.w())) {
            return;
        }

        g[e.v()][e.w()] = new Edge(e);
        if (e.v() != e.w() && !directed) {
            g[e.w()][e.v()] = new Edge(e.w(), e.v(), e.wt());
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w] != null;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != null) {
                    System.out.print(g[i][j].wt()+" \t");
                }
                else {
                    System.out.print("NULL\t");
                }
            }
            System.out.println();

        }
    }
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Edge<Weight>> adjV = new Vector<Edge<Weight>>();
        for (int i = 0; i < n; i++) {
            if (g[v][i] != null) {
                adjV.add(g[v][i]);
            }
        }
        return adjV;
    }

}
