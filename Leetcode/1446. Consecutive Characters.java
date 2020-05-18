class Solution {
    public int maxPower(String s) {
        if (s == null || s.length() == 0) { return 0; }
        int res = 0;
        int cnt = 0;
        Character prev = s.charAt(0);
        
        for (char c: s.toCharArray()) {
            if (c == prev) {
                cnt++;
            } else {
                prev = c;
                cnt = 1;
            }
            
            res = Math.max(res, cnt);
        }
        
        res = Math.max(res, cnt);
        
        return res;
    }
}
