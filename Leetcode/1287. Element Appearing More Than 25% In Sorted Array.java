class Solution {
  public int findSpecialInteger(int[] arr) {
      int n = arr.length;
      int count = 0;
      int prev = -1;
      int res = 0;
      
      for (int i = 0; i < arr.length; i++) {
          if (i == 0) {
              prev = arr[i];
              count = 1;
              continue;
          }
          
          if (arr[i] == prev) {
              count++;
          } else {
              if (((count * 1.0)/n) > 0.25) {
                  res = prev;
                  break;
              } else {
                  prev = arr[i];
                  count = 1;
              }
          }
      }
      
      if ((n/(count * 1.0)) > 0.25) {
          res = prev;
      }
      
      return res;
  }
}