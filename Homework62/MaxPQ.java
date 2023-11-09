package Homework62;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity+1];
    }

    public MaxPQ(Key[] keys){
        n = keys.length;
        pq = (Key[]) new Comparable[n+1];
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Key x) {
        pq[++n] = x;
        swim(n);
    }

    public Key max(){
        if(isEmpty()) throw new RuntimeException("Priority queue underflow");
        return pq[1];
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i]; pq[i] = pq[j]; pq[j] = swap;
    }
}
