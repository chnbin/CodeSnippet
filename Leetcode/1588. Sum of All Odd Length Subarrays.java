class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int len = 1;
            int sum = arr[i];
            res += sum;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                len++;
                if (len % 2 == 1) {
                    res += sum;
                }
            }
        }
        
        return res;
    }
}
