class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      
      // nums1 must be shorter than nums2
      if (nums1.length > nums2.length) {
          int[] tmp = nums1;
          nums1 = nums2;
          nums2 = tmp;
      }
      
      int m = nums1.length;
      int n = nums2.length;
      
      // Corner case
      if (m == 0 && n != 0) {
          if (n % 2 == 0) {
              return (nums2[n/2] + nums2[n/2 - 1]) / 2.0;
          } else {
              return (double)nums2[n/2];
          }
      }
      
      int left = 0;
      int right = m;
      int aux = (m + n + 1) / 2;
      
      while (left <= right) {
          int i = (left + right) / 2;
          int j = aux - i;
          
          if (i > 0 && nums2[j] < nums1[i-1]) {
              right = i - 1;
          } else if (i < m && nums1[i] < nums2[j-1]) {
              left = i + 1;
          } else {
              int leftMax = 0;
              
              if (i == 0) {
                  leftMax = nums2[j-1];
              } else if (j == 0) {
                  leftMax = nums1[i-1];   
              } else {
                  leftMax = Math.max(nums1[i-1], nums2[j-1]);
              }
              
              if (((m + n) & 1) != 0) {
                  return leftMax*1.0;
              }
              
              int rightMax = 0;
              
              if (i == m) {
                  rightMax = nums2[j];
              } else if (j == n) {
                  rightMax = nums1[i];
              } else {
                  rightMax = Math.min(nums1[i], nums2[j]);
              }
              
              return (leftMax + rightMax) / 2.0;
          }
          
      }
      
      return 0.0;
  }
}