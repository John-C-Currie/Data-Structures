package Homework4;

/* Implements Dijkstra's two stack algorithm for evaluating
 arithmetic expressions. The input expression is expected
 to be a String with spaces between the tokens, as on line
 12 below. The tokens are either arithmetic operations ("+",
 "-", "*", or "/"), brackets ("(" or ")"), or numbers. */

 // Exercise 9.1
 // Modify Dijkstra's Two Stack algorithm to evaluate expressions with square roots.

import Helpers.Stack;
import java.util.Scanner;

public class DijkstraSqrtEvaluation {
    public static void main(String[] args) {
        // read an expression whose tokens are separated by spaces:
        Scanner sc = new Scanner("( ( 1 + ( sqrt ( 5.0 ) ) / 2.0 )");

        // Dijkstra's two-stack algorithm:
        Stack<String> ops = new Stack<>();
        Stack<Double> values = new Stack<>();
        while (sc.hasNext()) {
            String s = sc.next();
            if (s.equals("("))
                ;
            else if (s.equals("+"))
                ops.push(s);
            else if (s.equals("-"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals("/"))
                ops.push(s);
            else if (s.equals("sqrt"))
                ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = values.pop();
                if (op.equals("+"))
                    v = values.pop() + v;
                else if (op.equals("-"))
                    v = values.pop() - v;
                else if (op.equals("*"))
                    v = values.pop() * v;
                else if (op.equals("/"))
                    v = values.pop() / v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);
                values.push(v);
            } else
                values.push(Double.parseDouble(s));
        }
        System.out.println(values.pop());
    }
}
