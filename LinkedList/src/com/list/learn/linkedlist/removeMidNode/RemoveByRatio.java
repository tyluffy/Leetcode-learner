package com.list.learn.linkedlist.removeMidNode;

/**
 * 删除单链表的a/b处的节点
 */
public class RemoveByRatio {

    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(3);
        node.next.next = new Node(4);
        node.next.next.next = new Node(5);

        Node node1 = removeByRatio(node, 1, 3);

        Node cur = node1;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }

    }

    public static Node removeByRatio(Node node, int a, int b) {
        if (node == null || a > b) {
            return node;
        }

        int n = 0;
        Node cur = node;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        n = (int)Math.ceil((double)(a * n) / (double) b);

        if (n == 1) {
            return node.next;
        }

        if (n > 1) {
            cur = node;
            while (--n != 1) {
                cur = cur.next;
            }

            cur.next = cur.next.next;
        }

        return node;
    }
}
