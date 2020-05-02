/*
  30 day leetcoding challenge
  Day 7. Counting Elements
  https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/

  Problem list does not include this problem so add it.
  Time Complexity : O(n), where n is the length of arr.
 */
class Solution {
  public int countElements(int[] arr) {
      if (arr.length == 1) { return 0;}
      int res = 0;
      int[] table = new int[1001];
      
      for (int num: arr) {
          table[num]++;
      }
      
      for (int i = 0; i < table.length - 1; i++) {
          if (table[i] > 0 && table[i+1] > 0) {
              res += table[i];
          }
      }
      
      return res;
  }
}
