package Homework3;

public class Exercise7_1 {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    //assuming a basic LinkedList that does not have a last pointer
    public LinkedList removeLast(LinkedList first) {
        LinkedList current = first;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return first;
    }

    public LinkedList delete(LinkedList first, int index) {
        if (index == 0) {
            return first.next;
        }
        LinkedList current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return first;
    }

    public boolean find(LinkedList first, int value) {
        LinkedList current = first;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Exercise7_1 ex = new Exercise7_1();
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
        //This creates a linked list 1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 4 -> 5 -> 5 -> 6 -> 6
        LinkedList result = ex.removeLast(first);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println(); //This should print 1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 4 -> 5 -> 5 -> 6

        result = ex.delete(first, 3);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println(); //This should print 1 -> 2 -> 2 -> 3 -> 3 -> 4 -> 5 -> 5 -> 6

        System.out.println(ex.find(first, 3)); //This should print true
        System.out.println(ex.find(first, 7)); //This should print false

    }
    
}
