package Homework62;

import Helpers.In;
import Helpers.Stopwatch;
import java.util.Arrays;

public class TopMints {

    public static void processInts(int m, String stream) {
        In in = new In(stream);
        int count = 0;
        Stopwatch timer = new Stopwatch();
        MinPQ pq = new MinPQ(m);
        while (!in.isEmpty()) {
            int i = in.readInt();
            if (pq.size() < m) {
                pq.insert(i);
            } else if (i > (int) pq.min()) {
                pq.delMin();
                pq.insert(i);
            }
            count++;
        }
        double time = timer.elapsedTime();
        System.out.println("Top " + m + " integers are :\n");
        while (!pq.isEmpty()) {
            System.out.println(pq.delMin());
        }
        System.out.println("\nIt took " + time + " seconds to process " + (count-1) + " integers.");
    }

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Processing 1 million integers using a priority queue");
        int m = 5; // keep only top m integers

        processInts(m,"https://gist.githubusercontent.com/david-dobor/b9008e5116f1816675fa15e2256b5168/raw/9baebd0943e90e0f98932ea4d53d1f508fa59dff/1Mints1.txt");

        System.out.print("\nTest 1\n------\n");
        // In in = new In("10ints.txt");
        // Uncomment the following line when you are ready to read the file with 1
        // million integers

        processInts(m, "10ints.txt");



        // MinPQ<Integer> pq = new MinPQ<>(m);

        // Stopwatch timer1 = new Stopwatch();
        // for (int i = 0; i < n; i++) {
        //     ints1[i] = in.readInt();
        //     pq.add(ints1[i]);
        //     // YOUR CODE HERE (1 or 2 lines should do the job)
        //     // remove minimum if m+1 entries on the PQ

        // }
        // double time1 = timer1.elapsedTime();

        // // print what's in the priority queue
        // System.out.printf("\t\t\tTop %d integers are\n", m);
        // for (Integer integer : pq) {
        //     System.out.println(integer);
        // }

        // // print the time it took to process the entire stream
        // System.out.printf("\nIt took %.2f seconds to process %,d integers " +
        //         "using a priority queue.\n", time1, n);

        // in.close();

        // Start Test 2 (this test sorts n integers and prints the largest m of them)
        System.out.print("\nTest 2\n------\n");

        // Test the time it takes to find m largest using sorting
        In in = new In("10ints.txt");
        int M = 5;
        int N = in.readInt(); // the first input integer is the number of input lines that follow
        Integer[] ints2 = new Integer[N];

        Stopwatch timer2 = new Stopwatch();
        for (int i = 0; i < N; i++) {
            ints2[i] = in.readInt();
        }
        Arrays.sort(ints2);

        double time2 = timer2.elapsedTime();

        // print the largest m integers of the sorted array
        System.out.printf("\t\t\tTop %d integers are\n", M);
        for (int i = N - M; i < N; i++) {
            System.out.println(ints2[i]);
        }

        // print the time it took to process the entire stream
        System.out.printf("\nIt took %.2f seconds to process %,d integers " +
                "by sorting them.\n", time2, N);

        in.close();
        System.out.println("-------------------------------------------------------------------");

    }
}

/*
 * 1. What is the result of running TopMints.java with 1,000,000 integers as input: output displayed in run
 * 
 * 2. How long did it take for Test 1 to complete on your computer? 0.001 seconds
 * 
 * 3. What is the Big-O running time of Test 1? O(n)
 * 
 * 4. How long did it take for Test 2 to complete on your computer? 0 seconds???
 * 
 * 5. What is the Big-O running time of Test 2? O(nlogn)
 * 
 */