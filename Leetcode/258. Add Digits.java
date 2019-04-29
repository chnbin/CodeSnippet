class Solution {
  public int addDigits(int num) {
      while (num >= 10) {
          int tmp = num;
          int sum = 0;
          while (tmp > 0) {
              sum += (tmp % 10);
              tmp /= 10;
          }
          num = sum;
      }
      return num;
  }
}