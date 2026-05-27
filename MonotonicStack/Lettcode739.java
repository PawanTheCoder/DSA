package MonotonicStack;
import java.util.Stack;

public class Lettcode739 {
    public static void main(String[] args) {
        int[] arr = { 30,60,90 };
        int[] result = dailyTemperatures(arr);
        for(int n : result) {
            System.out.print( n + " ");
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
       
        for(int i =0 ; i < temperatures.length; i++) {       
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int popedResult = stack.pop();
                result[popedResult] = i -popedResult ;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }

        return result;
    }
}
