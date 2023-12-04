package Assignment9;

import Helpers.In;
import Helpers.Stopwatch;

/******************************************************************************
 *  Compilation:  javac Insertion.java
 *  Execution:    java Insertion < input.txt
 *  Dependencies: In.java
 *  Data files:   10ints.txt
 *
 *  Sorts a sequence of integers from an input file using mergesort.
 *
 *  % more 10ints.txt
 *  10                        [first  line: how many integers to sort]
 *  4 1 3 2 16 9 10 14 8 7    [second line: the integers to sort ]
 *
 ******************************************************************************/

// Insertion class provides static methods for sorting an
// array of integers using insertion sort.
public class InsertionLab9 {

   // This class should not be instantiated.
   private InsertionLab9() {
   }

   // Rearranges the array in ascending order.
   public static void sort(int[] a) {
      int n = a.length;
      for (int i = 1; i < n; i++) {
         for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
            exch(a, j, j - 1);
         }
      }
   }


   // exchange a[i] and a[j] -- a helper method
   private static void exch(int[] a, int i, int j) {
      int swap = a[i];
      a[i] = a[j];
      a[j] = swap;
   }


   // print array to standard output
   private static void show(int[] a) {
      for (int i = 0; i < a.length; i++) {
         System.out.println(a[i]);
      }
   }

   // Reads in a sequence of integers from a file; insertion sorts them;
   // and prints them to standard output in ascending order.
   public static void main(String[] args) {
      In in = new In("100Kints.txt");
      int n = in.readInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
         a[i] = in.readInt();
      }

      Stopwatch timer = new Stopwatch();
      InsertionLab9.sort(a);
      double time = timer.elapsedTime();
      System.out.println("elapsed time = " + time);
      //show(a);
   }
}

// b. Big-O of sort() is O(n^2).
// c. Merge sort is much faster than Insertion sort. Time for 100k ints: 0.015s for merge sort, 3.75s for insertion sort.
// d. Both algorithms are stable.
// e. Whille merge sort is much fast, Insertion sort is requires much less memory. On top of this insertion sort is one of the fastest algorithms for sorting small arrays.
//    Insertion sort is also very easy to implement, only requiring a few lines of code. For simple sorting tasks, insertion sort is a good choice.