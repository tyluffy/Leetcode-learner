package com.list.learn.linkedlist.removeLastKthNode;

/**
 * 删除双链表中倒数第K个节点
 */
public class RemoveLastKthDoubleNode {

    public static void main(String[] args) {
        Node2 node2 = new Node2(1);

    }

    public static Node2 removeLastKthDoubleNode(Node2 node2, int k) {
        if (node2 == null || k <1) {
            return node2;
        }

        Node2 cur = node2;
        while (cur != null) {
             k--;
             cur = cur.next;
        }

        if (k == 0) {
            node2 = node2.next;
            node2.last = null;
        }

        if (k < 0) {
            cur = node2;
            while (++k != 0) {
                cur = cur.next;
            }
            Node2 newNex = cur.next.next;
            cur.next = newNex;
            if (newNex != null) {
                newNex.last = cur;
            }
        }

        return node2;
    }

 }

class Node2 {
    public int data;
    public Node2 next;
    public Node2 last;

    public Node2(int data) {
        this.data = data;
    }

    public Node2(int data, Node2 next, Node2 last) {
        this.data = data;
        this.next = next;
        this.last = last;
    }
}
