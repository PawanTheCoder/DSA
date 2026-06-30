package QueueDS.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class Leetcode127 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        int ans = ladderLength(beginWord, endWord, wordList);

        System.out.println(ans);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        if (beginWord.equals(endWord))
            return 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        HashSet<String> wordings = new HashSet<>(wordList);

        if (!wordings.contains(endWord))
            return 0;

        visited.add(beginWord);
        q.offer(beginWord);

        while (!q.isEmpty()) {

            count++;
            // Find the next string from wordings
            int size = q.size();

            for (int j = 0; j < size; j++) {
                String current = q.poll();

                if (current.equals(endWord))
                    return count;

                for (int i = 0; i < current.length(); i++) {
                    char[] arr = current.toCharArray();
                    char original = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;

                        if (wordings.contains(new String(arr)) && !visited.contains(new String(arr))) {
                            q.offer(new String(arr));
                            visited.add(new String(arr));
                        }
                    }
                    arr[i] = original;
                }
            }
        }

        return 0;
    }
}
