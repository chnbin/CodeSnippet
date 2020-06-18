class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) { return 0;}
        int res = 0;
        int left = 0;
        int right = citations.length - 1;
        int len = citations.length;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int hindex = len - mid;
            
            if (hindex == citations[mid]) {
                return len - mid;
            } else if (hindex < citations[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        
        return len - left;
    }
}
