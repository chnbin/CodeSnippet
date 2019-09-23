class Solution {
  public int smallestCommonElement(int[][] mat) {
      for (int i = 0; i < mat[0].length; i++) {
          int target = mat[0][i];
          
          for (int j = 1; j < mat.length; j++) {
              int find = binarySearch(mat[j], target);
              if (find == -1) {
                  target = -1;
                  break;
              }
          }
          if (target != -1) { return target;}
      }
      return -1;
  }
  
  private int binarySearch(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;
      
      while (left <= right) {
          int mid = (left + right) / 2;
          if (nums[mid] == target) {
              return mid;
          } else if (nums[mid] > target) {
              right = mid - 1;
          } else {
              left = mid + 1;
          }
      }
      return -1;
  }
}