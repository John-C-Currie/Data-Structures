
import java.util.*;

public class FastDijkstra {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IPQ Q;

    public FastDijkstra(WeightedDiGraph G, int source, int maxN) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        Q = new IPQ(maxN);

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
            Q.insert(v, Double.POSITIVE_INFINITY);
        }
        distTo[source] = 0;
        Q.decreaseKey(source, 0.0);

        while (!Q.isEmpty()) {
            int u = Q.delMin();
            for (DirectedEdge e : G.adj(u))
                relax(e);
        }
    }

    private void relax(DirectedEdge e) {
        int u = e.from(), v = e.to();
        if (distTo[v] > distTo[u] + e.weight()) {
            distTo[v] = distTo[u] + e.weight();
            edgeTo[v] = e;
            Q.decreaseKey(v, distTo[v]);
        }
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        ArrayDeque<DirectedEdge> path = new ArrayDeque<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}

