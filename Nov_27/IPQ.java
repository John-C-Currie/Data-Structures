import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;


public class IPQ {
    private int[] pq; // heap-ordered complete binary tree
    private int[] qp; // "quick position" inverse of pq - qp[pq[i]] = pq[qp[i]] = i
    private double[] keys; // keys[i] = priority of i
    private int N; // number of elements on PQ

    // Constructor initializes arrays and sets each element in qp to -1
    public IPQ(int maxN) {
        keys = new double[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return N == 0;
    }

    // Check if an element with index i is in the priority queue
    public boolean contains(int i) {
        return qp[i] != -1;
    }

    // Get the number of elements in the priority queue
    public int size() {
        return N;
    }

    // Insert an element with index i and priority key into the priority queue
    public void insert(int i, double key) {
        N++;
        qp[i] = N;
        pq[N] = i;
        keys[i] = key;
        swim(N); // Restore the heap order property by moving the element up
    }

    // Delete the element with the minimum priority and return its index
    public int delMin() {
        int min = pq[1];
        exch(1, N--);
        sink(1); // Restore the heap order property by moving the element down
        qp[min] = -1; 
        keys[min] = Double.POSITIVE_INFINITY; 
        pq[N + 1] = -1; 
        return min;
    }

    // Decrease the priority of an element with index i to key
    public void decreaseKey(int i, double key) {
        keys[i] = key;
        swim(qp[i]); // Restore the heap order property by moving the element up
    }

    // Helper method to compare priorities of elements at indices i and j
    private boolean greater(int i, int j) {
        return keys[pq[i]] > keys[pq[j]];
    }

    // Helper method to exchange elements at indices i and j and update qp
    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    // Bottom-up reheapify - move the element up to restore the heap order
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    // Top-down reheapify - move the element down to restore the heap order
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1))
                j++;
            if (!greater(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }
}
