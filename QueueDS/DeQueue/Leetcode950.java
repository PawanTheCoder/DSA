package QueueDS.DeQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode950 {
    public static void main(String[] args) {
        int[] deck = { 17, 13, 11, 2, 3, 5, 7 };
        int[] ans = deckRevealedIncreasing(deck);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
         int n = deck.length;
        Arrays.sort(deck); 
        System.out.println("Deck : " + Arrays.toString(deck));
        int[] result = new int[n];
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(i); 
        }

        System.out.println("Queue : " + q);
        
        for (int card : deck) {
            result[q.poll()] = card;
        
            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }
        
        return result;
    }
}
