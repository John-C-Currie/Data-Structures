package Homework3;

public class Exercise6_3 {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList deDup(LinkedList first) {
        LinkedList current = first;
        while (current != null) {
            LinkedList flag = current;
            while (flag.next != null) {
                if (flag.next.value == current.value) {
                    flag.next = flag.next.next;
                } else {
                    flag = flag.next;
                    break;
                }
            }
            current = current.next;
        }
        return first;
    } 

    public static void main(String[] args) {
        Exercise6_3 ex = new Exercise6_3();
        LinkedList first = new LinkedList(1);
        first.next = new LinkedList(2);
        first.next.next = new LinkedList(2);
        first.next.next.next = new LinkedList(3);
        first.next.next.next.next = new LinkedList(3);
        first.next.next.next.next.next = new LinkedList(3);
        first.next.next.next.next.next.next = new LinkedList(4);
        first.next.next.next.next.next.next.next = new LinkedList(5);
        first.next.next.next.next.next.next.next.next = new LinkedList(5);
        first.next.next.next.next.next.next.next.next.next = new LinkedList(6);
        first.next.next.next.next.next.next.next.next.next.next = new LinkedList(6);
        //Creates a linked list 1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 4 -> 5 -> 5 -> 6 -> 6

        LinkedList result = ex.deDup(first);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

 
}