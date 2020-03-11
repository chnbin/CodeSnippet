import java.util.Random;
class Solution {
    private int[] oriArray;
    private Random random;
    
    public Solution(int[] nums) {
        oriArray = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return oriArray.clone();
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = reset();
        
        for (int i = res.length - 1; i > 0; i--) {
            int k = random.nextInt(i+1);
            
            int tmp = res[i];
            res[i] = res[k];
            res[k] = tmp;
        }
        return res;
    }
}