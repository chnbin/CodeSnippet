class Solution {
    public int getWinner(int[] arr, int k) {
        int res = arr[0];
        int cnt = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (res < arr[i]) {
                res = arr[i];
                cnt = 0;
            }
            
            cnt++;
            if (cnt == k) {
                return res;
            }
        }
        
        return res;
    }
}
