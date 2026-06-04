package Basics;



public class Leetcode66 {
    public static void main(String[] args) {
        int[] digits = { 9,8,7,6,5,4,3,2,1,0 };
        StringBuilder str = new StringBuilder();
        for (int d : digits) {
            str.append(d);
        }
        System.out.println(str);

        int lastDigit = digits[digits.length - 1];

        int ans = lastDigit + 1;

        if(ans == 10) {
            int[] newArr = new int[digits.length + 1];
            int i =  digits.length -1;
            while(i >= 0 && digits[i] == 9) {
                newArr[i + 1] = 0;
                i--;
            }
            if(i == 0) {
                newArr[i] = 1;
            }else {
                newArr[i + 1] = digits[i] + 1;
            }
            for(int num : newArr) {
                System.out.println(num);
            }
        }
    }
}
