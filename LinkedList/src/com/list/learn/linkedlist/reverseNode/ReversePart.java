package com.list.learn.linkedlist.reverseNode;

/**
 * 反转部分单向链表
 */
public class ReversePart {

    public Node reversePart(Node node, int from , int to) {
        if (from < 1 || to < 1 || from > to) {
            return node;
        }

        Node node1 = node;
        Node pre = null;
        Node pos = null;
        int len = 0;
        while (node1 != null) {
            len ++;
            pre = len == from - 1 ? node1 : pre;
            pos = len == to - 1 ? node1 : pos;
            node1 = node1.next;
        }
        node1 = pre == null ? node : pre.next;
        Node node2 = node1.next;
        node1.next = pos;
        Node next = null;
        while (node2 != pos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        if (pre != null) {
            pre.next = node1;
            return node;
        }

        return node1;


    }
}
