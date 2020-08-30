package com.list.learn.linkedlist.removeLastKthNode;


/**
 * 删除单链表中倒数第K个节点
 */
public class RemoveLastKthNode {

    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(4);
        node.next.next = new Node(5);
        node.next.next.next = new Node(6);

        removeLastKthSigleNode(node, 3);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }

    }

    public static Node removeLastKthSigleNode(Node node, int k) {
        if (node == null || k < 1) {
            return node;
        }

        Node cur = node;
        while (cur != null) {
            k --;
            cur = cur.next;
        }
        if (k == 0) {
            node = node.next;
        }
        if (k < 0) {
            cur = node;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return node;
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
