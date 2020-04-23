/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixcalculator;

import liststacktemplate.MyList;
import liststacktemplate.MyStack;

/**
 *
 * @author adams
 */
public class Solver {

    String expression;

    /**
     * Sets a string to be solved.
     *
     * @param expression String to be set to class variable
     */
    public Solver(String expression) {
        this.expression = expression;
    }

    /**
     * Creates a List of all elements of the String set in the Class. Breaks
     * apart the expression set, separating numbers and operations.
     *
     * @return The separated list of operations and numbers
     */
    public MyList createList() {
        MyList list = new MyList();
        String current = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != ' ') {
                current = current + expression.charAt(i);
            } else {
                if ("+".equals(current) || "-".equals(current) || "*".equals(current) || "/".equals(current) || "^".equals(current)) {
                    list.add(current);
                    current = "";
                } else {
                    list.add(Double.parseDouble(current));
                    current = "";
                }
            }
        }
        list.add(current);
        System.out.println(list.toString());
        return list;
    }

    /**
     * Solves the correctly formatted list of a Post Fix expression. Uses a
     * stack to work through the passed in list one node as a time, following
     * the operations.
     *
     * @param list A correctly formatted post fix expression as a list
     * @return A string that is the answer of the expression
     */
    public String solve(MyList list) {
        MyStack stack = new MyStack();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if ("+".equals(list.get(i).toString())) {
                double second = (double) stack.pop();
                double first = (double) stack.pop();
                stack.push(first + second);
            } else if ("-".equals(list.get(i).toString())) {
                double second = (double) stack.pop();
                double first = (double) stack.pop();
                stack.push(first - second);
            } else if ("*".equals(list.get(i).toString())) {
                double second = (double) stack.pop();
                double first = (double) stack.pop();
                stack.push(first * second);
            } else if ("/".equals(list.get(i).toString())) {
                double second = (double) stack.pop();
                double first = (double) stack.pop();
                stack.push(first / second);
            } else if ("^".equals(list.get(i).toString())) {
                double second = (double) stack.pop();
                double first = (double) stack.pop();
                stack.push(Math.pow(first, second));
            } else {
                stack.push(list.get(i));
                System.out.println("Pushed : " + list.get(i));
            }
        }
        return stack.peek().toString();
    }
}
