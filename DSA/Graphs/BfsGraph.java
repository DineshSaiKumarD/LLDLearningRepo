package Graphs;

import java.util.*;

public class BfsGraph {


    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] vis = new boolean[V];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {

            int node = q.poll();
            ans.add(node);

            for(Integer it : adj.get(node)){
                if(!vis[it]){
                    q.add(it);
                    vis[it] = true;
                }
            }



        }


        return ans;

    }


    public static void main(String[] args) {
        BfsGraph bfsGraph = new BfsGraph();



        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        //adj input //[[0, 2], [0, 3], [0, 1], [2, 4]]
        adj.add(new ArrayList<>(Arrays.asList(2, 3,1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0,4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        ArrayList<Integer> integers = bfsGraph.bfsOfGraph(5, adj);

        System.out.println(integers);
    }
}
