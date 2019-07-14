class Solution {
  public int numberOfDays(int Y, int M) {
      if (M == 2) {
          return (isLeapYear(Y)) ? 29 : 28;
      }
      if (M == 4 || M == 6 || M == 9 || M == 11) {
          return 30;
      }
      return 31;
  }
  
  private boolean isLeapYear(int Y) {
      // 四年一閏，百年不閏，四百年又閏
      if (((Y%400) == 0) || ((Y%4) == 0 &&  (Y%100 != 0))) {
          return true;
      }
      return false;
  }
}