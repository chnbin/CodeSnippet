package tmp;
/*
  30 day leetcoding challenge
  Day 21. Leftmost Column with at Least a One
  https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/

  Problem list does not include this problem so add it.

  You can do binary search row by row and keep leftmost column, time complexity is O(r * logc), where r is the numbers of 
  matrix and c is the number of columns.

  This solution is starting from top-right and check the value,  time complexity is O(r * c), where r is the numbers of 
  matrix and c is the number of columns.
 */
class Solution {
  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
      List<Integer> l = binaryMatrix.dimensions();
      int m = l.get(0);
      int n = l.get(1);
      int res = -1;
      
      int row = 0;
      int col = n - 1;
      
      while (row < m && col >= 0) {
          int value = binaryMatrix.get(row, col);
          
          if (value == 1) {
              res = col;
              col--;
          } else {
              row++;
          }
      }
      
      return res;
  }
}