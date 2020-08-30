package com.list.learn.linkedlist.Palindromel;

import java.util.Stack;

public class Palindromel {

    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(3);
        node.next.next = new Node(3);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(2);
        System.out.println(isPalindromel2(node));

    }

    public static boolean isPalindromel(Node node) {
        Stack<Integer> stack = new Stack<>();
        Node cur = node;
        while (cur != null) {
            stack.push(cur.data);
            cur = cur.next;
        }

        cur = node;
        boolean flag = true;
        while (cur != null) {
            Integer pop = stack.pop();
            if (pop != cur.data){
                flag = false;
                break;
            }
            cur = cur.next;
        }

        return flag;
    }


    /**
     * 二分法
     * @param node
     * @return
     */
    public static boolean isPalindromel2(Node node) {
        Stack<Integer> stack = new Stack<>();
        Node right = node;
        Node cur = node;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }

        while (right != null) {
            stack.push(right.data);
            right = right.next;
        }

        while (!stack.isEmpty()){
            if (node.data != stack.pop()) {
                return false;
            }
            node = node.next;
        }
        return true;
    }


}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
