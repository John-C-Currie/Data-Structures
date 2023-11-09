package Oct18;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyPQTest {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(19);
        pq.offer(91);
        pq.offer(9);
        pq.offer(-1);
        pq.offer(21);
        pq.offer(68);
        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
    }
    
}
