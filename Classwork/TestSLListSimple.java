package Classwork;

public class TestSLListSimple {
   public static void main(String[] args) {
      SLListSimple<Integer> list = new SLListSimple<>();
      //list.removeFirst();  // should throw an Exception
      //list.removeLast();   // should throw an Exception
      list.addFirst(5); // 5 ->
      list.addFirst(7); // 7 -> 5 ->
      list.addLast(8); // 7 -> 5 -> 8 ->
      System.out.println(list);

      list.removeFirst(); // 5 -> 8 ->
      System.out.println(list);
      list.removeLast();  // 5 ->
      System.out.println(list);
      list.removeLast();  // This list is empty
      System.out.println(list);
   }
}
