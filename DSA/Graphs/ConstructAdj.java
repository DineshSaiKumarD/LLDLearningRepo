package Graphs;

import java.util.ArrayList;
import java.util.List;

public class ConstructAdj {


    public static void main(String[] args) {
    int V = 5; // Number of vertices in the graph


    int[][] edges = {{0, 2}, {0, 3}, {0, 1}, {2, 4}};


    List<List<Integer>> adj = new ArrayList<>();

    //prepare adj list
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        System.out.println(adj);
    }


}
