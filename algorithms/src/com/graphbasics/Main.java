package com.graphbasics;

public class Main {
    public static void main(String[] args) {

        // TestG1.txt
        String filename1 = "/path/to/testG1.txt";
        SparseGraph sparseGraph1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(sparseGraph1, filename1);
        Components components1 = new Components(sparseGraph1);
        System.out.println("TestG1.txt, Components Count: " + components1.count());
        System.out.println();

        // TestG2.txt
        String filename2 = "/path/to/testG2.txt";
        SparseGraph sparseGraph2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph(sparseGraph2, filename2);
        Components components2 = new Components(sparseGraph2);
        System.out.println("TestG2.txt, Components Count: " + components2.count());
    }
}
