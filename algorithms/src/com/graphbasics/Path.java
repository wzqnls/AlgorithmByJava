package com.graphbasics;

import java.util.Stack;
import java.util.Vector;

public class Path {
    /**
     * 图的引用
     */
    private Graph G;
    /**
     * 起始点
     */
    private int s;
    /**
     * 记录dfs节点是否被访问
     */
    private boolean[] visited;
    /**
     * from[i]表示查找的路径上i的上一个节点
     */
    private int[] from;

    // 图的深度优先遍历
    private void dfs(int v) {
        visited[v] = true;
        for (int i: G.adj(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    // 寻路算法，寻找graph从s点到其他点的路径
    public Path(Graph graph, int s) {
        G = graph;
        assert s >= 0 && s < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;

        dfs(s);
    }

    // 查询从s到w点是否有路径
    public boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    // 查询从s点到w点的路径，存放在vec中
    public Vector<Integer> path(int w) {
        assert hasPath(w);

        Stack<Integer> stack = new Stack<Integer>();
        // 通过from数组逆向查找从s到w的路径，存入栈中
        int p = w;
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }

        // 从栈中依次取出元素，存入向量中
        Vector<Integer> res = new Stack<Integer>();
        while (!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }

    // 打印从s到w点的路径
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
}
