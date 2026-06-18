package Linked_List.Pointers;

public class Leetcode61 {
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

        ListNode head =rotateRight(n1, 4);
        
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
            this.next = null;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
       if(head == null && head.next == null) return head;

       int size =0;
       ListNode curr = head;
       while(curr.next != null) {
        curr = curr.next;
        size++;
       }
       size++;
       int index = k % size;

       if(index == 0)  {
        System.out.println("Hello");
        return head;
       }
       curr.next = head;
       ListNode temp = head;
       System.out.println(temp.val);
       System.out.println(size - index);
       for(int i =1 ; i <= size - index -1;i++) {
        temp = temp.next;
       }
       System.out.println(temp.val + "temp");
       head = temp.next;
       temp.next = null;
       return head;
    }
}
