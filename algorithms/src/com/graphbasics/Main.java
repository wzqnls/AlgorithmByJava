package com.graphbasics;

public class Main {
    public static void main(String[] args) {

        // 使用两种图的存储方式读取G1文件
        String filename = "/path/to/testG1.txt";
        SparseGraph sparseGraph = new SparseGraph(13, false);
        ReadGraph r1 =  new ReadGraph(sparseGraph, filename);
        System.out.println("test G1 in Sparse Graph: ");
        sparseGraph.show();

        System.out.println();

        DenseGraph denseGraph = new DenseGraph(13, false);
        ReadGraph r2 =  new ReadGraph(denseGraph, filename);
        System.out.println("test G1 in Dense Graph: ");
        denseGraph.show();

        System.out.println();

        // 使用两种图的方式读取G2文件
        filename = "/path/to/testG2.txt";
        SparseGraph sparseGraph2 = new SparseGraph(6, false);
        ReadGraph r3 = new ReadGraph(sparseGraph2, filename);
        System.out.println("test G2 in Sparse Graph:");
        sparseGraph2.show();

        System.out.println();

        DenseGraph denseGraph2 = new DenseGraph(6, false);
        ReadGraph r4 = new ReadGraph(denseGraph2, filename);
        System.out.println("test G2 in Dense Graph:");
        denseGraph2.show();
    }
}
