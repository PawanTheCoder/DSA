package Hashes;
import java.util.*;

public class Leetcode13 {
    public static void main(String[] args) {
        String s = "LVIII";
        int ans = romanToInt(s);
        System.out.println(ans);

    }
    /*I             1
V             5
X             10
L             50
C             100
D             500
M             1000 */
    public static int romanToInt(String s) {
        int total = 0;
        HashMap<Character , Integer> map = new HashMap<>();
        
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);

        for(int i =0 ; i < s.length() ; i++) {
            int currentValue = map.get(s.charAt(i));
            if(i + 1 < s.length() && currentValue < map.get(s.charAt(i + 1))) {
                total -= currentValue;
            }
            else {
                total += currentValue;
            }
        }
        return total;
    }
}
