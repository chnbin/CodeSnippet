import java.util.Arrays;

class Solution {
  public int maxNumberOfApples(int[] arr) {
      int res = 0;
      Arrays.sort(arr);
      int total = 0;
      
      for (int i = 0; i < arr.length; i++) {
          total += arr[i];
          if (total < 5000) {
              res++;
          } else {
              return res;
          }
      }
      return res;
  }
}