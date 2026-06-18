package Linked_List.Pointers;

public class Leetcode82 {
     public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
       

        n1.next = n2;
        ListNode head = deleteDuplicates(n1);
        
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

     public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            System.out.println("Holla");
            return head;
        }
       ListNode dummy = new ListNode(0);
       ListNode tail = dummy;
       ListNode front = head;
       ListNode rear = head.next;

       while(rear != null) {

        if(rear != null && front.val == rear.val) {
            while(rear != null && rear.val == front.val) {
                rear = rear.next;
            }
            front = rear;
            rear = front.next;
            dummy.next = front;
            continue;
        }
        dummy.next = front;
        front = front.next;
        rear = rear.next;
        dummy = dummy.next;
       }

       return tail.next;
    }
}
