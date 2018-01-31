package com.minimumspantrees;

import java.util.Vector;

public class KruskalMST<Weight extends Number & Comparable> {
    /**
     * 最小生成树所包含的边
     */
    private Vector<Edge<Weight>> mst;
    /**
     * 最小生成树权值
     */
    private Number mstWeight;

    public KruskalMST(WeightedGraph graph) {
        mst = new Vector<Edge<Weight>>();

        // 将图中的所有边存放到一个最小堆中
        MinHeap<Edge<Weight>> pq = new MinHeap<Edge<Weight>>(graph.E());
        for (int i = 0; i < graph.V(); i++) {
            for (Object item: graph.adj(i)) {
                Edge<Weight> e = (Edge<Weight>)item;
                if (e.v() < e.w()) {
                    pq.insert(e);
                }
            }
        }

        UnionFind uf = new UnionFind(graph.V());
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {

            // 从最小堆中依次按序取出所有边
            Edge<Weight> e = pq.extractMin();
            /**
             * 判断两个端点是否已联通
             * 若已经联通则弃用
             * 否则会产生环
             */
            if (uf.isConnected(e.v(), e.w())) {
                continue;
            }

            /**
             * 将边添加至最小生成树
             * 同时将端点进行联通
             */
            mst.add(e);
            uf.unionElements(e.v(), e.w());
        }

        // 计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }
    }

    /**
     * 返回最小生成树的所有边
     */
    public Vector<Edge<Weight>> mstEdges() {
        return mst;
    }

    public Number result() {
        return mstWeight;
    }

    public static void main(String[] args) {

        String filename = "/Users/lishuo/Desktop/AlgorithmsByJava/algorithms/src/com/minimumspantrees/testG1.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Kruskal
        System.out.println("Test Kruskal:");
        KruskalMST<Double> kruskalMST = new KruskalMST<Double>(g);
        Vector<Edge<Double>> mst = kruskalMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + kruskalMST.result());

        System.out.println();
    }
}
