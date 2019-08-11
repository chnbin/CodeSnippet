class Solution {
  public int dayOfYear(String date) {
      int[] daysCnt = {0, 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      int year = computeYear(date.substring(0, 4));
      int month = computerMonthAndDate(date.substring(5, 7));
      int day = computerMonthAndDate(date.substring(8));
      if (isLeapYear(year)) { daysCnt[3] = 29; }
      
      int res = 0;
      for (int i = 1; i <= month; i++) {
          res += daysCnt[i];
      }
      
      return res + day;
  }
  
  private int computeYear(String year) {
      return ((year.charAt(0) - '0') * 1000 + 
              (year.charAt(1) - '0') * 100 +
              (year.charAt(2) - '0') * 10 +
              (year.charAt(3) - '0') ); 
  }
  
  private int computerMonthAndDate(String str) {
      return ((str.charAt(0) - '0') * 10 + 
              (str.charAt(1) - '0') ); 
  }
  private boolean isLeapYear(int year) {
      if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
          return true;
      }
      return false;
  }
}