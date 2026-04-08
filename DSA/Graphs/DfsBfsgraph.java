package Graphs;


import java.util.*;

class DfsBfsgraph {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            //print all the elements of vis array
           for(int j = 0; j < vis.length; j++) System.out.print(vis[j] + " ");
            if (!vis[i]) {dfs(i,adj, vis, ans);}
            System.out.println();
        }

        return ans;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> ans) {

        vis[node] = true;
        ans.add(node);

        for(int neighbour : adj.get(node)){
            if (!vis[neighbour]) {
                dfs(neighbour, adj, vis, ans);
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                bfs(i, adj, vis, ans);
            }
        }

        return ans;
    }

    private void bfs(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> ans) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            ans.add(current);

            for (int neighbor : adj.get(current)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }


    public static void main(String[] args) {
        DfsBfsgraph dfsBfsgraph = new DfsBfsgraph();
        //adj input //[[0, 2], [0, 3], [0, 1], [2, 4]]
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(2, 3,1));
        adj.add(Arrays.asList(0));
        adj.add(Arrays.asList(0,4));
        adj.add(Arrays.asList(0));
        adj.add(Arrays.asList(2));
        dfsBfsgraph.dfsOfGraph(5, adj);
    }


}

