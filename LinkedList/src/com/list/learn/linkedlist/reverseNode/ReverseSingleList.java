package com.list.learn.linkedlist.reverseNode;

/**
 * 反转单向链表
 */
public class ReverseSingleList {

    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(3);
        node.next.next = new Node(4);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(6);

        Node node1 = reverseSingleList(node);

        Node cur = node1;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }


    }

    public static Node reverseSingleList(Node node) {
        Node pre = null;
        Node next = null;

        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
