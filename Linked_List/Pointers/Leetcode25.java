package Linked_List.Pointers;

public class Leetcode25 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode head = reverseKGroup(n1, 2);
        
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        // Find the size of the list
        int size = 0;

        ListNode curr = head;

        while(curr != null) {
            size++;
            curr = curr.next;
        }

        int index = size / k;

        ListNode ptr = head;
        curr = head;
        ListNode temp = head;
        for(int i =0; i < index; i++) {
            if(i > 1) ptr =  temp;
            ListNode prev = null;

            for(int j = 0 ; j < k; j++) {
                if(i == 0) {
                    head = curr;
                }
                if(j == 0) {
                    temp = curr;
                }
                ListNode next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if(i == 0) continue;
            ptr.next = prev;
        }
        ListNode tail = head;

        while(tail.next != null) {
            tail = tail.next;
        }

        tail.next = curr;
        return head;
    }
}