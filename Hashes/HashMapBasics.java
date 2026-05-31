package Hashes;

import java.util.HashMap;

public class HashMapBasics {
    public static void main(String[] args) {
        // Declaration 
        HashMap<String , Integer> map = new HashMap<>();

        // Insert -O(1) average
        map.put("Apple" , 10);
        map.put("Banana" , 20);
        map.put("Orange" , 30);

        // Get values -O(1) average
        System.out.println(map.get("Apple")); // 10


        // Check if key exists
        System.out.println(map.containsKey("Banana")); // true

        // Check if value exists
        System.out.println(map.containsValue(20)); // true
        
        // Remove -O(1) average
        map.remove("Orange");

        // Iterate 
        for(String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        // Size
        System.out.println(map.size());

        System.out.println(map.getOrDefault("Grapes", 0));
    }
}
