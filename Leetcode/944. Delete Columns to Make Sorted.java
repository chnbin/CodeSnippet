class Solution {
  public int minDeletionSize(String[] A) {
      int res = 0;
      
      for (int i = 0; i < A[0].length(); i++) {
          int charCode = 0;
          boolean isDesc = false;
          for (int j = 0; j < A.length; j++) {
              int currCode = A[j].charAt(i);
              if (charCode > currCode) {
                  isDesc = true;
              }
              charCode = currCode;
          }
          if (isDesc) { res++; }
      }
      return res;
  }
}