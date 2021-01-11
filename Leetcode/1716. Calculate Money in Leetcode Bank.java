class Solution {
    public int totalMoney(int n) {
        int start = 0;
        int res = 0;
        
        while (n > 0) {
            if ((n / 7) >= 1) {
                res += (((1 + start + 7 + start)*7))/2;
                n -= 7;
            } else {
                res += ((1 + start + n + start) * n ) / 2;
                n -= n;
            }
            start++;
        }
        
        return res;
    }
}
