package com.list.learn.linkedlist.reverseNode;

/**
 * 反转双向链表
 */
public class ReverseDoubleList {

    public static void main(String[] args) {
        DoubleNode node = new DoubleNode(1, null, null);
        node.next = new DoubleNode(2, null, node);
        node.next.next = new DoubleNode(3, null, node.next);
        node.next.next.next = new DoubleNode(4, null, node.next.next);

        DoubleNode node1 = reverseDoubleList(node);

        DoubleNode cur = node1;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public static DoubleNode reverseDoubleList(DoubleNode node) {

        DoubleNode pre = null;
        DoubleNode next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            node.last = next;
            pre = node;
            node = next;

        }
        return pre;
    }

}

class DoubleNode{
    int data;
    DoubleNode next;
    DoubleNode last;

    public DoubleNode(int data) {
        this.data = data;
    }

    public DoubleNode(int data, DoubleNode next, DoubleNode last) {
        this.data = data;
        this.next = next;
        this.last = last;
    }
}
