package Homework4;

import Helpers.Stack;

public class MatchingBrackets {

    // Need to match brackets in the following pairs: (), [], {}
    // Use stack to store the opening brackets
    // If the current bracket is a closing bracket, check if it matches the top of the stack
    // If it does, pop the stack
    // If it doesn't, return the index of the current bracket
    // If the stack is not empty at the end, return the (String) index of the top of the stack
    // If the stack is empty at the end, return "Success"

    public static String matchBrackets(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (isOpenBracket(c)) {
                stack.push(c);
            } else if (isCloseBracket(c)) {
                if (stack.isEmpty()) {
                    return String.valueOf(i + 1);
                } else {
                    char top = stack.pop();
                    if (!isMatch(top, c)) {
                        return String.valueOf(i + 1);
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return "Success";
        } else {
            return String.valueOf(s.indexOf(stack.pop()) + 1);
        }
    }

    private static boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isCloseBracket(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean isMatch(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String s = "foo(bar[i]);";
        System.out.println(matchBrackets(s)); // should print Success
        s = "foo(bar[i);";
        System.out.println(matchBrackets(s)); // should print 10
        s = "([](){([])})";
        System.out.println(matchBrackets(s)); // should print Success
        s = "()[]}";
        System.out.println(matchBrackets(s)); // should print 5
        s = "{}{{"; // should print 1
        System.out.println(matchBrackets(s));
    }
}
