import java.util.HashSet;

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
      HashSet<Integer> set = new HashSet<Integer>();
      HashSet<Integer> intersectionSet = new HashSet<Integer>();
      for (int num: nums1) { set.add(num); }
      for (int num: nums2) {
          if (set.contains(num)) {
              intersectionSet.add(num);
          }
      }
      
      int[] ans = new int[intersectionSet.size()];
      int i = 0;
      for (Integer n: intersectionSet) {
          ans[i++] = n;
      }
      return ans;
  }
}