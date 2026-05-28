package MonotonicStack;

import java.util.*;

public class Leetcode556 {
    public static void main(String[] args) {
        int num = 21;
        int ans = nextGreaterElement(num);
        System.out.println(ans);
    }
    public static int nextGreaterElement(int n) {
        if(n > Integer.MAX_VALUE) {
            return -1;
        }
        StringBuilder str = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();

        int num = n;
        while(num != 0) {
            arr.add(num % 10);
            num /= 10;
        }
        Collections.reverse(arr);
List<Integer> newArr = new ArrayList<>(arr);

        

        int size = newArr.size();
        boolean isValid = false;
        for(int i = size -1 ; i >= 0 ; i--) {
            for(int j = i - 1; j >=0; j--) {
                if(newArr.get(j) <newArr.get(i)) {
                    int temp = newArr.get(i);
                    newArr.set(i , arr.get(j));
                    newArr.set(j , temp);
                    isValid = true;
                    break;
                }
            }
            if(isValid == true) {
                break;
            }
        }
        for(int i = 0;i < newArr.size() ; i++) {
            str.append(newArr.get(i));
        }
        
        String newStr = str.toString();
        int newNum = Integer.parseInt(newStr);
        if(newNum != n) {
            return newNum;
        }

        return -1;
    }
}
