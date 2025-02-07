package linkedlist;

public class LinkedListExec {


    /**
     * https://leetcode.com/problems/reverse-linked-list/
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode curr = head.next;

        prev.next = null;
//         ListNode temp;
//         while(curr != null) {
//            temp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = temp;
//         }

//         return prev;
        return helper(prev, curr);
    }

    public ListNode helper(ListNode prev, ListNode node) {
        if (node == null) {
            return prev;
        }
        ListNode tmp = node.next;
        node.next = prev;
        return helper(node, tmp);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * TODO
     * reverse-linked-list-II
     * swap-nodes-in-pairs
     */
}

