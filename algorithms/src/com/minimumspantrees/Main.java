package com.minimumspantrees;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        String filename = "/Users/lishuo/Desktop/AlgorithmsByJava/algorithms/src/com/minimumspantrees/testG1.txt";
        SparseWeightedGraph<Double> sparseWeightedGraph = new SparseWeightedGraph<Double>(8, false);
        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(sparseWeightedGraph, filename);

        // test lazy prim mst
        System.out.println("Test Lazy Prim MST: ");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(sparseWeightedGraph);
        Vector<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.elementAt(i));
        }
        System.out.println("The MST weight is: " + lazyPrimMST.result());
        System.out.println();
    }

}
