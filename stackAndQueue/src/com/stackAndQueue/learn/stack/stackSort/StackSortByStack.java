package com.stackAndQueue.learn.stack.stackSort;

import java.util.Stack;

public class StackSortByStack {

    public static void sort(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            Integer newValue = stack.pop();
            while (!help.isEmpty() && help.peek() < newValue) {
                stack.push(help.pop());
            }
            help.push(newValue);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);

        sort(stack);
        System.out.println(stack);
    }
}
