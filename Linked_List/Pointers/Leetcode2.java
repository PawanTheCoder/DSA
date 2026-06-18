package Linked_List.Pointers;

public class Leetcode2 {
 public static void main(String[] args) {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(0);
        ListNode n13 = new ListNode(3);
        ListNode n14 = new ListNode(4);
        ListNode n15 = new ListNode(5);

        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;

        ListNode n21 = new ListNode(5);
        ListNode n22 = new ListNode(4);
        ListNode n23 = new ListNode(3);
        ListNode n24 = new ListNode(2);
        ListNode n25 = new ListNode(1);

        n21.next = n22;
        n22.next = n23;
        n23.next = n24;
        n24.next = n25;

        ListNode head1 = n11;
        ListNode head2 = n21;

        ListNode head = addTwoNumbers(head1, head2);
        
        while(head!= null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static class ListNode {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry =0;
        while(l1 != null || l2 != null || carry != 0) {
            int x = (l1 == null) ? 0:l1.val;
            int y = (l2 == null) ? 0:l2.val;

            int sum = x + y + carry;

            carry = sum / 10;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}