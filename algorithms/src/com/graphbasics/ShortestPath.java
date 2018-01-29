package com.graphbasics;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class ShortestPath {

    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] from;
    /**
     * 记录节点中的次序
     */
    private int[] ord;

    public ShortestPath(Graph graph, int s) {
        G = graph;
        assert s >= 0 && s < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];
        ord = new int[G.V()];

        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;

        /**
         * 无向图最短路径算法， 从s开始广度优先遍历整张图
         */
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.push(s);
        visited[s] = true;
        ord[s] = 0;
        while (!q.isEmpty()) {
            int v = q.pop();
            for ( int i: G.adj(v)) {
                if (!visited[i]) {
                    q.push(i);
                    visited[i] = true;
                    ord[i] = ord[v] + 1;
                    from[i] = v;
                }
            }
        }

    }

    // 查询从s到w点是否有路径
    public boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    // 查询从s到w的路径， 存放在vector中
    public Vector<Integer> path(int w) {
        assert hasPath(w);

        Stack<Integer> stack = new Stack<Integer>();
        int p = w;
        while(p != -1) {
            stack.push(p);
            p = from[p];
        }

        // 从栈中依次取出元素，存入Vector中
        Vector<Integer> res = new Vector<Integer>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }
    // 打印从s到w的路径
    public void showPath(int w) {
        Vector<Integer> vector = path(w);
        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.elementAt(i));
            if (i != vector.size() - 1) {
                System.out.print(" --> ");
            }
            else {
                System.out.println();
            }
        }
    }

    public int length(int w) {
        assert w >= 0 && w < G.V();
        return ord[w];
    }
}
