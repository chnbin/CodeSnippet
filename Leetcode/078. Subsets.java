import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int total = (int)Math.pow(2.0, nums.length);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < total; i++) {
            List<Integer> sol = new ArrayList<>();
            int curr = i;
            for (int j = 0; j < 32; j++) {
                if (((curr >> j) & 1) == 1) {
                    sol.add(nums[j]);
                }
            }
            res.add(sol);
        }
        
        return res;
    }
}
