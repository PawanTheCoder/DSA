package Hashes.BasicTemplate;
import java.util.*;

public class Leetcode12 {
    public static void main(String[] args) {
        int num = 1994;
        String ans = intToRoman(num);
        System.out.println(ans);
    }

     public static  String intToRoman(int num) {
        // HashMap<Character , Integer> map = new HashMap<>();

        // map.put('I' , 1);
        // map.put('V' , 5);
        // map.put('X' , 10);
        // map.put('L' , 50);
        // map.put('C' , 100);
        // map.put('D' , 500);
        // map.put('M' , 1000);

        ArrayList<Character> romans = new ArrayList<>();

        romans.add('I');
        romans.add('V');
        romans.add('X');
        romans.add('L');
        romans.add('C');
        romans.add('D');
        romans.add('M');

        ArrayList<Integer> nums = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        int number = num;
        while(number != 0) {
            nums.add( number % 10);
            number /= 10;
        }
        int count = 0;
        int whatisSize  =0;
        if(nums.size() == 4) {
            whatisSize = 3;
        }else {
            whatisSize = nums.size();
        }
        for(int i =0 ; i < whatisSize ; i++) {
            char ones = romans.get(count);
            char fives = romans.get(count + 1);
            char tens = romans.get(count + 2);

            if(nums.get(i) == 1) {
                stack.push(ones);
            }else if(nums.get(i) == 2) {
                stack.push(ones);
                stack.push(ones);
            }else if(nums.get(i) == 3) {
                stack.push(ones);
                stack.push(ones);
                stack.push(ones);
            }else if(nums.get(i) == 4) {
                stack.push(fives);
                stack.push(ones);
            }else if(nums.get(i) == 5) {
                stack.push(fives);
            }
            else if(nums.get(i) == 6) {
                stack.push(ones);
                stack.push(fives);
            }else if(nums.get(i) == 7) {
                stack.push(ones);
                stack.push(ones);
                stack.push(fives);
            }else if(nums.get(i) == 8) {
                stack.push(ones);
                stack.push(ones);
                stack.push(ones);
                stack.push(fives);
            }else if(nums.get(i) == 9) {
                stack.push(tens);
                stack.push(ones);
            }
            count += 2;
        }

        if(count >= 6) {
            for(int i = 0 ; i < nums.get(3); i++) {
                stack.push('M');
            }
        }
        StringBuilder finalString = new StringBuilder();
        while(!stack.isEmpty()) {
            finalString.append(stack.pop());
        }
        return finalString.toString();
    }
}
