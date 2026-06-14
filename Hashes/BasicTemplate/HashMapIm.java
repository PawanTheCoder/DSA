package Hashes.BasicTemplate;

import java.util.HashMap;

public class HashMapIm {
    public static void main(String[] args) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < 10; i++) {
            map.getOrDefault(i,i+1);
        }  
        System.out.println(map);      
    }
}
