/*
  30 day leetcoding challenge
  Day 21. Leftmost Column with at Least a One
  https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/

  Problem list does not include this problem so add it.

  [Solution 1] Binary search
  You can do binary search row by row and keep leftmost column, time complexity is O(r * logc), where r is the numbers of 
  matrix and c is the number of columns.

  [Solution 2] Two pointer
  This solution is starting from top-right and check the value,  time complexity is O(r * c), where r is the numbers of 
  matrix and c is the number of columns.
 */
class Solution {
  // Solution1
  public int leftMostColumnWithOneBinarySearch(BinaryMatrix binaryMatrix) {
    List<Integer> d = binaryMatrix.dimensions();
    int m = d.get(0);
    int n = d.get(1);
    int res = Integer.MAX_VALUE;
    
    for (int i = 0; i < m; i++) {
        int left = 0;
        int right = n - 1;
        int idx = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            // System.out.println("i = " + i + ";mid =" + mid);
            int value = binaryMatrix.get(i, mid);
            
            if (value == 1) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (idx != -1) {
            res = Math.min(res, idx);   
        }
    }
    
    res = (res == Integer.MAX_VALUE) ? -1 : res;
    
    return res;
  }
  // Solution2
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