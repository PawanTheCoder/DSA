package Basics;
import java.util.Stack;

public class InvalidateBaseball {
    public static void main(String[] args) {
      String[] ops = {"5" , "2" , "C", "D" , "+" };
      System.out.println(calPoints(ops));
    }
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < operations.length ; i++) {
            if(operations[i].equals("D")) {
                int prev = stack.pop();
                int next = prev  * 2;
                stack.push(prev);
                stack.push(next);
                continue;
            }
            if(operations[i].equals("C") && stack.isEmpty() == false) {
                stack.pop();
                continue;
            }
            if(operations[i].equals("+")) {
                int x = stack.pop();
                int y = stack.pop();
                int z = x + y;
                stack.push(y);
                stack.push(x);
                stack.push(z);
                continue;
            }
            int num = Integer.parseInt(operations[i]);
            stack.push(num);
        }
        int ans = 0;
        for(int num : stack) {
            ans += num;
        }
        return ans;
    }
}
