package Homework61;
import java.util.LinkedList;
import java.util.Queue;

public class BTInverter {
   // O(n) time, O(n) space
   public static void invert(BinaryTree tree) {
      // iterative solution
      Queue<BinaryTree> q = new LinkedList<>();
      q.add(tree);
      while (!q.isEmpty()) {
         BinaryTree current = q.remove();
         if (current == null) continue;
         exchangeLeftAndRight(current);
         if (current.left != null)
         q.add(current.left);
         if (current.right != null)
         q.add(current.right);
      }
      // recursive solution
      // if (tree == null) return;
      // invert(tree.left);
      // invert(tree.right);
      // exchangeLeftAndRight(tree);
   }

   private static void exchangeLeftAndRight(BinaryTree tree) {
      BinaryTree temp = tree.left;
      tree.left = tree.right;
      tree.right = temp;
   }



   // inner class, represents a binary tree
   static class BinaryTree{
      int key;            // node data
      BinaryTree left;    // this node's left subtree
      BinaryTree right;   // this node's right subtree

      // constructor: initializes data, sets subtrees to null
      public BinaryTree( int key ) { this.key = key; }
   }

   public static void main(String[] args) {
      /* TEST 1 */
      BTInverter.BinaryTree rt = new BTInverter.BinaryTree(2);
      // left subtree of rt
      rt.left = new BinaryTree(1);
      rt.left.left = new BinaryTree(8); rt.left.right = new BinaryTree(4);
      rt.left.right.left = new BinaryTree(7); rt.left.right.right = new BinaryTree(9);
      // right subtree of rt
      rt.right = new BinaryTree(6); rt.right.left = new BinaryTree(5);
      BTInverter.show(rt);
      System.out.println();

      // WHEN DONE, THE FOLLOWING TWO LINES WILL OUTPUT THE INVERTED TREE
      BTInverter.invert(rt);
      BTInverter.show(rt);

      /* TEST 2 */
      BTInverter.BinaryTree rt2 = new BTInverter.BinaryTree(1);
      rt2.left = new BinaryTree(2); rt2.right = new BinaryTree(3);
      rt2.left.left = new BinaryTree(4); rt2.left.right = new BinaryTree(5);
      rt2.right.left = new BinaryTree(6); rt2.right.right = new BinaryTree(7);
      rt2.left.left.left = new BinaryTree(8); rt2.left.left.right = new BinaryTree(9);
      System.out.println();
      BTInverter.show(rt2);
      System.out.println();
      BTInverter.invert(rt2);
      BTInverter.show(rt2);
      System.out.println();
   }

   public static void show(BinaryTree bt) {
      Queue<BinaryTree> q = new LinkedList<>();
      q.add(bt);
      while (!q.isEmpty()) {
         BinaryTree t = q.remove();
         if (t == null) continue;
         System.out.printf("%s ", t.key); // output node data
         q.add(t.left);
         q.add(t.right);
      }
   }
}

