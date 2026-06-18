package Linked_List.Pointers;

public class Leetcode328 {
     public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = n2;
        
        ListNode head = n1;
        oddEvenList(head);
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
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

    public static ListNode oddEvenList(ListNode head) {
        if(head == null ) return null;
        if(head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode track = head;
        ListNode tail= head.next;
        ListNode ptr = tail;

        while(tail != null && tail.next != null) {
            track.next = ptr;
            dummy.next = track;
            track = tail.next;
            tail.next = tail.next.next;
            tail= track.next;
            dummy = dummy.next;
        }

        if(track != null) {
            dummy.next = track;
            track.next = ptr;
        }

        return head;
    }
}
