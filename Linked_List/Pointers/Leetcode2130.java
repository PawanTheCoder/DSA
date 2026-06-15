package Linked_List.Pointers;

public class Leetcode2130 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode head = n1;
        int ans = pairSum(head);
        System.out.println(ans);
    }

  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public static int pairSum(ListNode head) {
        int maxSum =0;

        // Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        // Now that we have middle of the list reverse the list from head to slow
        ListNode prev = null;
        ListNode curr = slow;

        while(curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr = head;
        ListNode second = prev;
        while(second != null) {
            int num1= curr.val;
            int num2 = second.val;
            maxSum = Math.max(num1+ num2 , maxSum);
            curr = curr.next;
            second = second.next;
        }
        return maxSum;
    }
}

