package Homework3;

public class Exercise7_2 {
    public static class LinkedList {
        public int value;
        public int size;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public int findMid(LinkedList first, int size) {
        LinkedList current = first;
        for (int i = 0; i < size / 2; i++) {
            current = current.next;
        }
        return current.value;
    }

    public LinkedList reverse(LinkedList first) {
        LinkedList current = first;
        LinkedList prev = null;
        while (current != null) {
            LinkedList next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Exercise7_2 ex = new Exercise7_2();
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
        first.size = 11;
        //This creates a linked list 1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 4 -> 5 -> 5 -> 6 -> 6

        System.out.println(ex.findMid(first, first.size)); //This should print 3
        LinkedList result = ex.reverse(first); //This should print 6 -> 6 -> 5 -> 5 -> 4 -> 3 -> 3 -> 3 -> 2 -> 2 -> 1
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

}
