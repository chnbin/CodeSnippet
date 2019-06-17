class Solution {
  public int[] getModifiedArray(int length, int[][] updates) {
      int[] range = new int[length+1];
      int[] res = new int[length];
      for (int[] update: updates) {
          range[update[0]] += update[2];
          range[update[1] + 1] -= update[2];
      }
      
      int sum = 0;
      for (int i = 0; i < length; i++) {
          sum += range[i];
          res[i] = sum;
      }
      return res;
  }
}