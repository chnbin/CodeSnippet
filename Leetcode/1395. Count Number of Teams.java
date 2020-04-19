class Solution {
  public int numTeams(int[] rating) {
      if (rating.length < 3) { return 0; }
      
      int res = 0;
      
      for (int i = 0; i < rating.length - 2; i++) {
          int left = rating[i];
          for (int j = i + 1; j < rating.length - 1; j++) {
              int mid = rating[j];
              for (int k = j + 1; k < rating.length; k++) {
              int right = rating[k];
              
              if (left < mid && mid < right) {
                  res++;
                  continue;
              }
              
              if (left > mid && mid > right) {
                  res++;
                  continue;
              }
          }
          }
      }
      
      return res;
  }
}
