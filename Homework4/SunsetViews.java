package Homework4;

import Helpers.Stack;

public class SunsetViews {
    // O(n) time, O(n) space
    // Use stack,
    // Push to stack if the building is taller than the previous one
    // Since the building on top will be larger than the ones below it, we know that the ones below will be smaller than the current one
    // This means all buildings in the stack will be visible
    // Direction can be decided by positive or negative increment

    public static Stack<Integer> sunsetViews(int[] buildings, String direction) {
        Stack<Integer> stack = new Stack<>();
        int n = buildings.length;
    
        if (direction.equals("WEST")) {
            for (int i = 0; i < n; i++) {
                if (stack.isEmpty() || buildings[i] > buildings[stack.peek()]) {
                    stack.push(i);
                }
            }
        } else { // "WEST" direction
            for (int i = n - 1; i >= 0; i--) {
                if (stack.isEmpty() || buildings[i] > buildings[stack.peek()]) {
                    stack.push(i);
                }
            }
        }
    
        return stack;
    }

    public static void main(String[] args) {
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "WEST";
        Stack<Integer> west = sunsetViews(buildings, direction);
        System.out.println(west); // should print [0, 1]
        direction = "EAST";
        Stack<Integer> east = sunsetViews(buildings, direction);
        System.out.println(east); // should print [1, 3, 6, 7]

    }
}
