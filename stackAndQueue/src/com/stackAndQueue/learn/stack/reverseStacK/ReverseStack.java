package com.stackAndQueue.learn.stack.reverseStacK;


import java.util.Stack;

public class ReverseStack {

    public int getAndRevmoveStack(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.empty()) {
            return result;
        } else {
            Integer last = getAndRevmoveStack(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.empty()){
            return;
        }

        int laset = getAndRevmoveStack(stack);
        reverse(stack);
        stack.push(laset);
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        ReverseStack reverseStack = new ReverseStack();
        reverseStack.reverse(stack);
        System.out.println(stack);
    }
}
