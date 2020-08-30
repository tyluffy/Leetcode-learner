package com.list.learn.linkedlist.removeMidNode;

/**
 * 删除单链表的中间节点
 */
public class RemoveMideNode {

    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(3);
        node.next.next = new Node(4);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(6);

        removeMidNode(node);

        Node cur = node;
        while (cur != null) {
            System.out.println(cur.data);
            cur= cur.next;
        }

    }

    public static Node removeMidNode(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        if (node.next.next == null) {
            return node.next;
        }

        Node pre = node;
        Node cur = node.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;

        return node;
    }

}

class Node{
    public int data;

    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
