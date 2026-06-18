package Linked_List.Pointers;

import java.util.ArrayList;

public class Leetcode23 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        ListNode n4 = n1;
        ListNode n5 = new ListNode(3);
        ListNode n6 = n2;
        n4.next = n5;
        n5.next = n6;
        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(6);
        n7.next = n8;
        ListNode[] arr = {n1 , n4 , n7};

        ListNode head = mergeKLists(arr);

        while(head != null) {
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

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i < lists.length;i++) {
            ListNode curr = lists[i];
            while(curr != null) {
                ans.add(curr.val);
                curr = curr.next;
            }
        }

        ans.sort(null);
        System.out.println(ans);
        ListNode head = dummy;
        for(int i=0; i < ans.size(); i++) {
            dummy.next = new ListNode(ans.get(i));
            dummy = dummy.next;
        }
        return head.next;
    }
}
