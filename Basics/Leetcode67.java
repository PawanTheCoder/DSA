package Basics;
import java.util.Stack;

public class Leetcode67 {
    public static void main(String[] args) {
        String num1 = "100111";
        String num2 = "11101";
        System.out.println(addBinary(num1, num2));
    }

    public static String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());

        // Pad both strings with leading zeros
        a = String.format("%" + maxLength + "s", a).replace(' ', '0');
        b = String.format("%" + maxLength + "s", b).replace(' ', '0');
        System.out.println(a.length() + " " + b.length());

        StringBuilder ans = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        for(int i =a.length() - 1 ; i >= 0 ; i--) {
            char aNum = a.charAt(i);
            char bNum = b.charAt(i);
            if(!stack.isEmpty() && stack.peek() == 1) {
                if(aNum == '1' && bNum == '1') {
                    ans.append('1');
                    System.out.println("Max Executed");
                }else if(aNum == '1' || bNum == '1') {
                    ans.append('0');
                    System.out.println("Stack = 1 , a or b = 1");
                }else {
                    ans.append('1');
                    System.out.println("Stack = 1 , a and b = 0");
                    stack.pop();
                }
            }else {
                if(aNum == '1' && bNum == '1') {
                    System.out.println("Satck = 0 , a and b = 1");
                    stack.push(1);
                    ans.append(0);
                }else if(aNum == '1' || bNum == '1') {
                    System.out.println("Stack = 0 , a or b = 1");
                    ans.append('1');
                }else {
                    System.out.println("All 0");
                    ans.append('0');
                }
            }
        }
        if(!stack.isEmpty() && stack.peek() == 1) {
            ans.append('1');
            stack.clear();
        }
        System.out.println(ans);
        return ans.reverse().toString();
    }
}
