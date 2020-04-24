class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // Sliding window
        int lowerBound = threshold * k;
        int res = 0;
        int total = 0;
        
        for (int i = 0; i < k; i++) {
            total += arr[i];
        }
        
        if (total >= lowerBound) {
            res++;
        }
        
        for (int i = k; i < arr.length; i++) {
            total -= arr[i - k];
            total += arr[i];
            
            if (total >= lowerBound) {
                res++;
            }
        }
        return res;
    }
}
