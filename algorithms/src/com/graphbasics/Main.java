package com.graphbasics;

public class Main {
    public static void main(String[] args) {

        // TestG2.txt
        String filename = "/path/to/testG2.txt";
        SparseGraph sparseGraph = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(sparseGraph, filename);
        sparseGraph.show();
        System.out.println();

        Path path = new Path(sparseGraph, 0);
        System.out.println("Path from 0 to 4: ");
        path.showPath(4);
    }
}
