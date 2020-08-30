package com.list.learn.linkedlist.printCommanPart;


/**
 * 打印两个有序链表的公共部分
 */
public class PrintCommonPart {

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(4);
        node1.next.next = new Node(6);

        Node node2 = new Node(2);
        node2.next = new Node(4);
        node2.next.next = new Node(7);

        printCommonPart(node1, node2);
    }


    public static void printCommonPart(Node node1, Node node2) {
        while (node1 != null && node2 != null) {
            if (node1.data > node2.data) {
                node2 = node2.next;
            } else if (node1.data < node2.data) {
                node1 = node1.next;
            } else {
                System.out.println(node1.data);
                node1 = node1.next;
                node2 = node2.next;
            }
        }
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
