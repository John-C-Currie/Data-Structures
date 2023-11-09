package Homework4;

import java.util.Queue;
import java.util.Stack;

public class StackToQueue {

    public static void stackToQueue(Stack<Integer> s, Queue<Integer> q){
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new java.util.LinkedList<>();
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        // s = 4 -> 3 -> 2 -> 1
        stackToQueue(s, q);
        // s = empty
        // q = 1 -> 2 -> 3 -> 4
        System.out.println(q);
    }
    
}
