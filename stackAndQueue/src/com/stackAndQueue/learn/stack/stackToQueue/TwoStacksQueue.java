package com.stackAndQueue.learn.stack.stackToQueue;

import java.util.Stack;

public class TwoStacksQueue {

    private Stack<Integer> stackPush;

    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        this.stackPop = new Stack<>();
        this.stackPush = new Stack<>();
    }

    public void add(Integer value) {
        stackPush.add(value);
        pushToPop();
    }

    public Integer poll() {
        pushToPop();
        return stackPop.pop();
    }

    private void pushToPop() {
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }


    public Integer peek() {
        pushToPop();
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}
