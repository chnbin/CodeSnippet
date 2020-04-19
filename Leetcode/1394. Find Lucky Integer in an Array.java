class Solution {
  public int findLucky(int[] arr) {
      int[] table = new int[501];
      
      for (int num: arr) {
          table[num]++;
      }
      
      for (int i = table.length - 1; i > 0; i--) {
          if (i == table[i]) {
              return i;
          }
      }
      
      return -1;
  }
}
