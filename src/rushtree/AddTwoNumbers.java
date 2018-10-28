package rushtree;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        int isOver = 0;
        ListNode p1 = l1, p2 = l2;
        ListNode p1b = l1, p2b;
        for (; p1 != null && p2 != null; p1 = p1.next, p2 = p2.next) {
            int nodeVal = (p1.val + p2.val + isOver) % 10;
            isOver = (p1.val + p2.val + isOver) / 10;
            p1.val = nodeVal;
            p2.val = nodeVal;
            p1b = p1;
        }
        if (p1 == null && p2 == null) {
            if (isOver == 0)
                return l1;
            else {
                p1b.next = newNode();
                return l1;
            }
        }
        if (p1 == null) {
            if(isOver==0) return l2;
            p2b=p2;
            for (; p2 != null; p2 = p2.next) {
                int nodeVal = (p2.val + isOver) % 10;
                isOver = (p2.val + isOver) / 10;
                p2.val = nodeVal;
                p2b=p2;
                if(isOver==0)
                    break;
            }
            if (isOver == 0)
                return l2;
            else {
                p2b.next = newNode();
                return l2;
            }
        }

        if (p2 == null) {
            if(isOver==0)
                return l1;
            p1b = p1;
            for (; p1 != null; p1 = p1.next) {
                int nodeVal = (p1.val + isOver) % 10;
                isOver = (p1.val + isOver) / 10;
                p1.val = nodeVal;
                p1b = p1;
                if(isOver==0)
                    break;
            }
            if (isOver == 0)
                return l1;
            else {
                p1b.next = newNode();
                return l1;
            }
        }
        return l1;
    }

    private ListNode newNode() {
        ListNode newNode = new ListNode(1);
        newNode.next = null;
        return newNode;
    }
/*
    public static void main(String[] args) {

    }*/
}
