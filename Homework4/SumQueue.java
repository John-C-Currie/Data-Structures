package Homework4;

import java.util.Queue;

public class SumQueue {

    public static int sumQueue(Queue<Integer> q){
        int sum = 0;
        for(int i = 0; i < q.size(); i++){
            int n = q.remove();
            sum += n;
            q.add(n);
        }
        return sum;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new java.util.LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q); //This should print [1, 2, 3, 4, 5]
        System.out.println(sumQueue(q)); //This should print 15
        System.out.println(q); //This should print [1, 2, 3, 4, 5]
    }
    
}
