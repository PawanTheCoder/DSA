package MonotonicStack;

import java.util.Stack;

public class Leetcode768 {
    public static void main(String[] args) {
        int[] arr = {4 , 0 , 2 , 1, 3};
        int result = maxChunksToSorted(arr);
        System.out.println(result);
    }

    public static int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        int maxIndex = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
            while(!stack.isEmpty() &&  arr[i] > arr[stack.peek()]) {
                int index = stack.pop();
                result[index] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        System.out.println(maxIndex);
        

        for(int num : result) {
            System.out.print( num + " ");
        }
        return 0;
    }
    
}
