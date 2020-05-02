/*
  30 day leetcoding challenge
  Day 14. Perform String Shifts
  https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/
 */
class Solution {
  public String stringShift(String s, int[][] shift) {
      int n = s.length();
      
      int amount = 0;
      for (int[] sh: shift) {
          int rotation = sh[0];
          
          if (rotation == 0) {
              amount += sh[1];
          } else {
              amount -= sh[1];
          } 
      }
      amount = (amount % n);
      
      System.out.println("R: " + amount);
      if (amount < 0) {
              s = reverseString(s, 0, (n - 1));
              
              s = reverseString(s, 0, (-amount - 1));
              //System.out.println(s);
              s = reverseString(s, -amount, n - 1);
              //System.out.println(s);
          } else {
              s = reverseString(s, 0, n - 1);
              //System.out.println(s);
              s = reverseString(s, 0, n - amount - 1);
              //System.out.println(s);
              s = reverseString(s, n - amount, n - 1);
              //System.out.println(s);
          }
      
      return s;
  }
  
  private String reverseString(String s, int begin, int end) {
      char[] chars = s.toCharArray();
      
      while (begin < end) {
          char tmp = chars[begin];
          chars[begin] = chars[end];
          chars[end] = tmp;
          
          begin++;
          end--;
      }
      
      return new String(chars);
  }
}
