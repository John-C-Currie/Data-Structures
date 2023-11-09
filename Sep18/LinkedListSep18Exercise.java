package Sep18;
/* A minimalistic, bare-bones linked list. It is not generic and can
   only add elements to its front. It is helpful as a starter file
   for practice with writing new linked list methods.                */

public class LinkedListSep18Exercise {
   Node first;  // reference to the first node
   int size;    // the number of items on this list

   /* Class Node: stores data and a link to another Node */
   class Node {
      private Object data;
      private Node next;
   }

   /* adds an item to the front of the list */
   void add(Object item) {
      Node oldfirst = first;
      first = new Node();
      first.data = item;
      first.next = oldfirst;
      size++;
   }

   /* reverses this list in-place */
   void reverse() {
      Node prev = null;
      Node current = first;
      Node next = null;
      while (current != null) {
         next = current.next;
         current.next = prev;
         prev = current;
         current = next;
      }
      first = prev;
   }


   public static void main(String[] args) {
      LinkedListSep18Exercise list = new LinkedListSep18Exercise();
      list.add(8); list.add(6); list.add(1); list.add(2);

      /* this for loop prints 2 -> 1 -> 6 -> 8 -> */
      for (Node x = list.first; x != null; x = x.next)
         System.out.print(x.data + " -> ");

      System.out.println();

      /* If your reverse() is correct, uncomment the following lines to print 8 -> 6 -> 1 -> 2 -> */
     list.reverse();
     for (Node x = list.first; x != null; x = x.next)
        System.out.print(x.data + " -> ");

   }
}
