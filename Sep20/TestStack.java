import Helpers.In;
import Helpers.Stack;

public class TestStack {
   public static void main(String[] args) {
      // TEST 1: a stack of Strings
      Stack<String> stack1 = new Stack<>();
      In in = new In("tobe.txt");
      while (!in.isEmpty()) {
         String item = in.readString();
         if (!item.equals("-")) stack1.push(item);
         else if (!stack1.isEmpty()) System.out.print(stack1.pop() + " ");
      }
      System.out.println("(" + stack1.size() + " left on stack)");

      // TEST 2: a stack of Integers
      Stack<Integer> stack2 = new Stack<>();
      in = new In("someInts.txt");    // input: 2 1 6 8
      while (!in.isEmpty())
         stack2.push(in.readInt());    // push each integer onto the stack
      for (int i : stack2)             // iterate through the stack
         System.out.print(i + " ");   // output 8 6 1 2 (input reversed)

      System.out.println();

      // TEST 3: another stack of Strings
//      Stack<String> stack = new Stack<>();
//      Scanner sc = new Scanner("one fish two fish red fish blue fish");
//      while (sc.hasNext()) {
//         String item = sc.next();
//         if (!item.equals("fish"))
//            stack.push(item);    // push only "one" "two" "red" "blue"
//      }
//      System.out.println(stack); // should print "blue  red  two  one"
   }
}
