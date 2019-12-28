class Solution {
  public int[] replaceElements(int[] arr) {
      if (arr == null || arr.length == 0) {
          return arr;
      }
      
      if (arr.length == 1) {
          arr[0] = -1;
          return arr;
      }
      
      int[] rightMax = new int[arr.length];
      for (int i = rightMax.length - 2; i >= 0; i--) {
          rightMax[i] = Math.max(rightMax[i+1], arr[i+1]);
      }
      rightMax[arr.length - 1] = -1;
      return rightMax;
  }
}