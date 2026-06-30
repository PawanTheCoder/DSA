package LinerDS_MegaPractice;

import java.util.HashMap;

public class Leetcode1171 {
    public static void main(String[] args) {
        // 1,2,-3,3,1
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(-3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = removeZeroSumSublists(n1);
        while(head != null) {
            System.out.print(head.val + "-> ");
            head = head.next;
        }
        System.out.println("NULL");
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

    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode curr = head;
        int size =0;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        System.out.println(size);
        curr = head;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0,0);
        System.out.println(map);
        int prefix =0;
        
        for(int i=0; i<size; i++) {
            prefix += curr.val;
            if(map.containsKey(prefix)) {
                System.out.println("Hello");
                int startIndex = map.get(-prefix);
                int endIndex = i;
                System.out.println("StartIndex : " + startIndex);
                if(startIndex == 0) {
                    ListNode temp = head;
                    for(int j=0; j <=i ; j++) {
                        map.remove(map.get(temp.val));
                        temp = temp.next;
                    }
                    map.remove(temp.val);
                    head = temp;
                    System.out.println(map);
                    continue;
                }
                
                else {
                    ListNode temp = head;
                for(int j = 0; j < startIndex - 1; j++) {
                    temp = temp.next;
                }

                ListNode temp2 = temp.next;
                for(int j = startIndex ; j < endIndex; j++) {
                    temp2 = temp2.next;
                }
                temp.next = temp2;
                }
            }

            map.put(prefix , i + 1);
            curr = curr.next;
            System.out.println(map);
        }
        return head;
    }
}