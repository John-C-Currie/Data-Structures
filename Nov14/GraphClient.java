package Nov14;

import Helpers.In;

public class GraphClient {

    public static int vertexDegree(Graph g, int v){
        int degree = 0;
        for (int w : g.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph g){
        int max = 0;
        for (int v = 0; v < g.V(); v++)
            if (vertexDegree(g, v) > max)
                max = vertexDegree(g, v);
        return max;
    }

    public static int averageDegree(Graph g){
        return 2 * g.E() / g.V();
    }

    public static int numberOfSelfLoops(Graph g){
        int count = 0;
        for (int v = 0; v < g.V(); v++)
            for (int w : g.adj(v))
                if (v == w) count++;
        return count/2;
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(new In("tinyG.txt"));
        System.out.println(g);
        System.out.println("Max degree: " + maxDegree(g));
        System.out.println("Average degree: " + averageDegree(g));
        System.out.println("Number of self loops: " + numberOfSelfLoops(g));
        System.out.println("Degree of vertex 0: " + vertexDegree(g, 0));
    }


    
}
