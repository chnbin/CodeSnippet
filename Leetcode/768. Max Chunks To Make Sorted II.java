import java.util.Arrays;

class Solution {
  public int maxChunksToSorted(int[] arr) {
      int res = 0;
      int[] sortedArr = arr.clone();
      Arrays.sort(sortedArr);
      int[] diff = new int[arr.length];
      
      for (int i = 0; i < arr.length; i++) {
          diff[i] = sortedArr[i] - arr[i];
      }
      
      int sum = 0;
      
      for (int i = 0; i < diff.length; i++) {
          sum += diff[i];
          
          if (sum == 0) {
              res++;
          }
      }
      return res;
  }
}