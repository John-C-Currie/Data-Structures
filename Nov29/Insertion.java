package Nov29;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Helpers.In;

// Insertion class provides static methods for sorting an
// array of integers using insertion sort.
public class Insertion {

   // This class should not be instantiated.
   private Insertion() {
   }

   // Rearranges the array in ascending order.
   public static void sort(Comparable[] a) {
      int n = a.length;
      for (int i = 1; i < n; i++) {
         for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
            exch(a, j, j - 1);
         }
      }
   }

   private static boolean less(Comparable x, Comparable y) {
      return x.compareTo(y) < 0;
   }

   // exchange a[i] and a[j] -- a helper method
   private static void exch(Comparable[] a, int i, int j) {
      Comparable swap = a[i];
      a[i] = a[j];
      a[j] = swap;
   }

   // print array to standard output
   private static void show(Comparable[] a) {
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i] + " ");
      System.out.println();
   }

   // Reads in a sequence of integers from a file; insertion-sorts them;
   // and prints them to standard output in ascending order.
   public static void main(String[] args) {
      // 1. Read the file "10ints.txt"
      Scanner in;
      try {
         in = new Scanner(new File("10intsSort.txt"));
      } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
      }

      int n = in.nextInt();
      Integer[] a = new Integer[n];
      for (int i = 0; i < n; i++) {
         a[i] = in.nextInt();
      }
      // 2. Sort the integers using insertion sort
      Insertion.sort(a);
      // 3. Print the result
      show(a); // your output should be: 1 2 3 4 7 8 9 10 14 16

      // Test 2
      // Sorting Strings

      In in2 = new In("words3.txt");
      String[] words = in2.readAllStrings();
      Insertion.sort(words);
      show(words);
   }
}