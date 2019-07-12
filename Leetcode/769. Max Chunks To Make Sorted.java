class Solution {
  public int maxChunksToSorted(int[] arr) {
      int res = 0;
      int maxDist = 0;
      
      for (int i = 0; i < arr.length; i++) {
          maxDist = Math.max(maxDist, arr[i]);
          if (i == maxDist) {
              res++;
          }
      }
      return res;
  }
}