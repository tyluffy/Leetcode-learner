package com.list.learn.linkedlist.josepushKill;

/**
 * 环形单链表的约瑟夫问题
 */
public class JosePushKill {

    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(3);
        node.next.next = new Node(4);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(6, node);
        Node node1 = josePushKill(node, 3);
        System.out.println(node1.data);

    }

    /**
     * 复杂度 m * n
     */
    public static Node josePushKill(Node head, int m) {
        if (head == null || m < 1) {
            return head;
        }

        Node last = head;
        while (last.next != head) {
            last = last.next;
        }

        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    /**
     * 复杂度N 数学公式没推到出来
     */
    public static Node josePushKill2(Node head, int m) {
        return head;
    }

}

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
