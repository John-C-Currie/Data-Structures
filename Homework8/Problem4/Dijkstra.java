package Homework8.Problem4;

import java.util.*;
import Helpers.In;

public class Dijkstra {
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        int[] distTo = new int[adj.length];
        boolean[] marked = new boolean[adj.length];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Integer.MAX_VALUE;
        }
        distTo[s] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(adj.length, new Comparator<Integer>() {
            public int compare(Integer v, Integer w) {
                return distTo[v] - distTo[w];
            }
        });

        pq.add(s);

        while (!pq.isEmpty()) {
            int v = pq.remove();
            marked[v] = true;
            relax(adj, cost, v, distTo);
            for (int w : adj[v]) {
                if (!marked[w]) {
                    pq.add(w);
                }
            }
        }

        return distTo[t] == Integer.MAX_VALUE ? -1 : distTo[t];
    }

    private static void relax(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int v, int[] distTo) {
        for(int i = 0; i < adj[v].size(); i++) {
            if (distTo[adj[v].get(i)] > distTo[v] + cost[v].get(i)) {
                distTo[adj[v].get(i)] = distTo[v] + cost[v].get(i);
            }
        }
    }

    public static void main(String[] args) {
        In in = new In("G4-1.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = in.readInt();
            y = in.readInt();
            w = in.readInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = in.readInt() - 1;
        int y = in.readInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}
