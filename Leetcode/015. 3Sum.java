import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Ugly...
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
     List<List<Integer>> res = new ArrayList<List<Integer>>();
     if (nums == null || nums.length == 0) { return res; }
     if (nums.length < 3) { return res; }
     Arrays.sort(nums);
     int prev = nums[0]-1;
     for (int i = 0; i < nums.length - 1; i++) {
         if (nums[i] != prev) { 
           List<Integer> partAns = new ArrayList<>();
           prev = nums[i];
           int left = i + 1;
           int right = nums.length - 1;
           int total = 0;
           while (left < right) {
               total = nums[i] + nums[left] + nums[right];
               if (total == 0) {
                   partAns.add(nums[i]);
                   partAns.add(nums[left++]);
                   partAns.add(nums[right--]);
                     res.add(new ArrayList<Integer>(partAns));
                   partAns.clear();
                   while (nums[right] == nums[right+ 1] && right > left) {
                       right--;
                   }
                     while (nums[left] == nums[left-1] && left < right) {
                       left++;
                   }
               } else if (total > 0) {
                   right--;
               } else {
                   left++;
               }
           }
         }
     }
     return res;
 }
}