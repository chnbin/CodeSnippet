class Solution {
    public int maxScore(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int n = s.length() - 1;
        
        int[] zeroPrefix = new int[n];
        int[] onePrefix = new int[n];
        int prefixSum = 0;
        
        for (int i = 0; i <= n - 1; i++) {
            if (s.charAt(i) == '0') {
                prefixSum++;
            }
            zeroPrefix[i] = prefixSum;
        }
        
        prefixSum = 0;
        
        for (int i = n; i >= 1; i--) {
            if (s.charAt(i) == '1') {
                prefixSum++;
            }
            onePrefix[i-1] = prefixSum;
        }
        
        for (int i = 0; i < zeroPrefix.length; i++) {
            res = Math.max(res, zeroPrefix[i] + onePrefix[i]);
        }
        
        return res;
    }
}
