class Solution {
  public int rotatedDigits(int N) {
      // 寫出例子就可以找出規律
      // 3 , 4, 7無法翻轉，有出現任何一個則保證不是good number
      // 0 , 1, 8其實不影響
      // 2 , 5, 6, 9翻轉會改變數字
      // 13 -> false, 14 -> false, 15 變12 -> true
      // 用很大的數字來看1111111111121111111111 -> true
      // 因此，只要數字裡面有一位數是2, 5, 6, 9 就可以算而且這個數字不可以有3, 4, 7
      int res = 0;
      for (int i = 1; i <= N; i++) {
          if (isGood(i)) { res++; }
      }
      return res;
  }
  
  private boolean isGood(int n) {
      boolean flag = false;
      
      while (n > 0) {
          int d = n % 10;
          if (d == 3 || d == 4 || d == 7) {
              return false;
          } else if (d == 2 || d == 5 || d == 6 || d == 9) {
              flag = true;
          }
          n /= 10;
      } 
      
      return flag;
  }
}