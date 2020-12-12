class Solution {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        
        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            
            for (int w: accounts[i]) {
                wealth += w;
            }
            
            res = Math.max(res, wealth);
        }
        
        return res;
    }
}
