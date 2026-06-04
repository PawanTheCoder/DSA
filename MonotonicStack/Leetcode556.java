package MonotonicStack;

public class Leetcode556 {
  public static void main(String[] args) {
    int a = 12443322;
    int ans = nextGreaterElement(a);
    System.out.println(ans);
  }

   public static int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        System.out.print("Input Number : ");
        for(char c : arr) {
            System.out.print(c + " ");
        }

        // Step 1 : Find pivot
        int i = arr.length -2;
        while(i >=0 && arr[i] >= arr[i+1]) {
            i--;
        }


        // No next permutation exists
        if(i < 0) {
            return -1;
        }

        // Step 2 : Find just larger element
        int j = arr.length -1;

        while(arr[j] <= arr[i]) {
            j--;
        }

        // Swap we got i and j both now swap
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // Step 3: Reverse suffix
        reverse(arr, i + 1, arr.length - 1);

        // Convert back to number
        long ans = Long.parseLong(new String(arr));

        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
   }
   private static void reverse(char[] arr , int left , int right) {
    while(left < right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left ++;
        right --;
    }
   }
}
