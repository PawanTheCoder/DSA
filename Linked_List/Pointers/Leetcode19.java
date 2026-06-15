package Linked_List.Pointers;

public class Leetcode19 {
     public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode head = n1;
        head = removeNthFromEnd(head, 5);
        
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;

        ListNode curr = head;
        while(curr != null) {
            size++;
            curr = curr.next;
        }

        System.out.println("Size : " + size );
        int index = size - n;
        System.out.println("Index  : " + index);
        if(index == 0) {
            System.out.println("I am getting");
            head = head.next;
            return head;
        }
        curr = head;
        for(int i =0 ; i < index - 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return head;
    }
}
