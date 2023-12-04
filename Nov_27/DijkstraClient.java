import java.util.Scanner;
import java.util.ArrayList;
import Helpers.In;
import Helpers.Stopwatch;

public class DijkstraClient {
    public static void main(String[] args) {
        In in = new In("https://gist.githubusercontent.com/david-dobor/3c2b943c17ee70d6a8f220b1c4440534/raw/75e92b12798e6ad7be345f7dcfa105c5a7d39ab6/10000EWG.txt");
        WeightedDiGraph wg = new WeightedDiGraph(in);
        int vertices = wg.V();
        Stopwatch sw = new Stopwatch();
        Dijkstra dijkstra = new Dijkstra(wg, 0);
        Double elapsedTime = sw.elapsedTime();
        System.out.println("Dijkstra's algorithm took " + elapsedTime + " seconds.");
        System.out.println(dijkstra.distTo(2168));
        System.out.println(dijkstra.pathTo(2168));
        System.out.println();
        
        Stopwatch sw2 = new Stopwatch();
        FastDijkstra fDijkstra = new FastDijkstra(wg, 0, vertices);
        Double elapsedTime2 = sw2.elapsedTime();
        System.out.println("Fast Dijkstra's algorithm took " + elapsedTime2 + " seconds.");
        System.out.println(fDijkstra.distTo(2168));
        System.out.println(fDijkstra.pathTo(2168));
    }
    
}
