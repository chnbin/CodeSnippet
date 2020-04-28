class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int currSum = 0;
        int res = 0;
        
        Arrays.sort(satisfaction);
        
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            currSum += satisfaction[i];
            
            if (currSum < 0) {
                continue;
            }
            
            res += currSum;
        }
        
        return res;
    }
}
