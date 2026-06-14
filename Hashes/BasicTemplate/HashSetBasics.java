package Hashes.BasicTemplate;

import java.util.HashSet;

public class HashSetBasics {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // Add -O(1) Average
        set.add(1);
        set.add(2);
        set.add(3);

        // Check existence - O(1)
        System.out.println(set.contains(1));

        // Remove(1);

        // Iterate
        for(int num : set) {
            System.out.println(num);
        }
    }
}
