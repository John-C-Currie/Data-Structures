package Classwork;
/* A simplified implementation of the linked list data structure.
 *  This version allows clients to add or remove items from the
 *  beginning or the end of the list only.                          */

public class SLListSimple<E> {
   private Node<E> first;   // reference to the first node
   private Node<E> last;    // reference to the last node
   private int n;           // the number of items on this list

  /* Node is a static nested class. Node is private because list clients
     need not manipulate nodes directly (or even know about them)    */
   private static class Node<E> {
      private E data;
      private Node<E> next;
   }

   /* adds an item to the front of the list */
   public void addFirst(E item) { 
      Node<E> newNode = new Node<>();
      newNode.data = item;
      newNode.next = first;
      first = newNode;
      if (isEmpty()) last = newNode;
      n++;
   } // TODO

   /* adds an item to the end of the list */
   public void addLast(E value) { 
      Node<E> newNode = new Node<>();
      newNode.data = value;
      newNode.next = null;
      if (isEmpty()) {
         first = newNode;
         last = newNode;
      } else {
         last.next = newNode;
         last = newNode;
      }
      n++;
   } // TODO

   /* removes and returns the first element from the list */
   public E removeFirst() { 
      if (isEmpty()) throw new RuntimeException("This list is empty");
      E item = first.data;
      first = first.next;
      n--;
      if (isEmpty()) last = null;
      return item;
   }

   /* removes and returns the last element from the list */
   public E removeLast() { 
      if (isEmpty()) throw new RuntimeException("This list is empty");
      E item = last.data;
      if (n == 1) {
         first = null;
         last = null;
      } else {
         Node<E> current = first;
         while (current.next.next != null) {
            current = current.next;
         }
         current.next = null;
         last = current;
      }
      n--;
      return item;
    } // TODO

   /* returns true if the list is empty, false otherwise */
   public boolean isEmpty() { return n == 0;}

   /* returns the size of this list */
   public int size() {return n;}

   /* returns a String representation of this list */
   public String toString() {
      StringBuilder s = new StringBuilder();
      if (isEmpty()) return "This list is empty ";
      Node current = first;
      while (current != null) {
         s.append(current.data + " -> ");
         current = current.next;
      }
      return s.toString();
   }
}
