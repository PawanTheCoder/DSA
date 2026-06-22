package QueueDS.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode752 {
    public static void main(String[] args) {
        String target = "0202";

        String[] deadlocks = {"0201","0101","0102","1212","2002"};
        int ans = openLock(deadlocks, target);
        System.out.println(ans);
    }

    public static int openLock(String[] deadends, String target) {
        int moves =0;
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();

        if(dead.contains("0000")) return -1;

        Queue<String> q = new LinkedList<>();

        q.offer("0000");
        visited.add("0000");

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i < size ; i++){
                String current =q.poll();

                if(current.equals(target)) {
                    return moves;
                }

                for(String next : getNeighbors(current)) {

                    if(dead.contains(next)) continue;

                    if(visited.contains(next)) continue;

                    q.offer(next);
                    visited.add(next);
                }
            }
            moves ++;
        }

        return moves;
    }

    private static List<String> getNeighbors(String current) {
        List<String> numbers = new ArrayList<>();
        char[] c = current.toCharArray();

        for(int i =0; i < 4 ; i++) {
            char num = c[i];

            // Forward by 1
            c[i] = (char) ((num - '0' + 1) % 10 + '0');
            numbers.add(new String(c));

            // Backward by 1
            c[i] = (char) ((num - '0' + 9) % 10 + '0');
            numbers.add(new String(c));

            c[i] = num;
        }
        return numbers;
    }
}
