package com.graphbasics;

public class Components {
    /**
     * 图的引用
     */
    Graph G;
    /**
     * 记录dfs过程中节点是否被访问
     */
    private boolean[] visited;
    /**
     * 记录联通分量个数
     */
    private int ccount;
    /**
     * 每个节点对应联通分量的标记
     */
    private int[] id;

    // 图的深度优先遍历
    public void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;

        for (int i: G.adj(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public Components(Graph graph) {
        // 算法初始化
        G = graph;
        visited = new boolean[G.V()];
        id = new int[G.V()];
        ccount = 0;
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }

        // 求图的联通分量
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount += 1;
            }
        }
    }

    public int count() {
        return ccount;
    }

    public boolean isConnected(int v, int w) {
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }

}
