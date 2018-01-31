package com.minimumspantrees;

import java.util.Vector;

public class LazyPrimMST<Weight extends Number & Comparable> {

    private WeightedGraph<Weight> G;
    private MinHeap<Edge<Weight>> pq;
    private boolean[] marked;
    /**
     * 最小生成树所包含的所有边
     */
    private Vector<Edge<Weight>> mst;
    /**
     * 最小生成树的权值
     */
    private Number mstWeight;

    public LazyPrimMST(WeightedGraph<Weight> graph) {

        //算法初始化
        G = graph;
        pq = new MinHeap<Edge<Weight>>(G.E());
        marked = new boolean[G.V()];
        mst = new Vector<Edge<Weight>>();

        // Lazy Prim
        visit(0);
        while(!pq.isEmpty()) {
            // 使用最小堆找出已经访问的边中权值最小的边
            Edge<Weight> e = pq.extractMin();
            // 如果这条边已经访问过则弃用
            if (marked[e.v()] == marked[e.w()]) {
                continue;
            }
            // 否则，将这条边添加至mst
            mst.add(e);

            if (!marked[e.v()]) {
                visit(e.v());
            }
            else {
                visit(e.w());
            }
        }

        // 计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }

    }

    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;

        // 将和节点v相连接的所有未访问的边放入最小堆中
        for (Edge<Weight> e: G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    public Vector<Edge<Weight>> mstEdges() {
        return mst;
    }

    public Number result() {
        return mstWeight;
    }
}
