package com.minimumspantrees;

public class Main {

    public static void main(String[] args) {
        String filename = "/Users/lishuo/Desktop/AlgorithmsByJava/algorithms/src/com/minimumspantrees/testG1.txt";
        SparseWeightedGraph<Double> sparseWeightedGraph = new SparseWeightedGraph<Double>(8, false);
        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(sparseWeightedGraph, filename);
        System.out.println("test G1 in SparseWeightedGraph: ");
        sparseWeightedGraph.show();

        System.out.println();

        DenseWeightedGraph<Double> denseWeightedGraph = new DenseWeightedGraph<Double>(8, false);
        ReadWeightedGraph readWeightedGraph1 = new ReadWeightedGraph(denseWeightedGraph, filename);
        System.out.println("test G1 in DenseWeightedGraph: ");
        denseWeightedGraph.show();

        System.out.println();
    }

}
