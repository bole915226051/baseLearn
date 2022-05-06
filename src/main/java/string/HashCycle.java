package string;

import java.util.HashSet;
import java.util.Set;

public class HashCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public static boolean hashCycle(ListNode head) {
        Set<ListNode> listNode = new HashSet<ListNode>();
        while (head != null) {
            if (listNode.contains(head)) {
                return true;
            } else {
                listNode.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        boolean flag = hashCycle(node1);
        System.out.println(flag);
    }
}
