class Solution {
  public int findKthPositive(int[] arr, int k) {
      int[] table = new int[2001];
      
      for (int num: arr) {
          table[num]++;
      }
      
      int cnt = 0;
      
      for (int i = 1; i < 2001; i++) {
          if (table[i] == 0) {
              cnt++;
              if (cnt == k) {
                  return i;
              }
          }
      }
      return -1;
  }
}
