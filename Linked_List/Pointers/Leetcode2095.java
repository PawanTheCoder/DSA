package Linked_List.Pointers;

public class Leetcode2095 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
       

        n1.next = n2;

        ListNode head = n1;
        deleteMiddle(head);

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

    public static ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr =head;
        while(curr.next != slow) {
            curr= curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

}
