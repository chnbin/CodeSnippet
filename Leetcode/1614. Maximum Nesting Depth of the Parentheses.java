class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int cnt = 0;
        
        for (char c: s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                maxDepth = Math.max(maxDepth, cnt);
                cnt--;
            }
        }
        
        return maxDepth;
    }
}
