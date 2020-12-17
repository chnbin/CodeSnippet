class Solution {
    public String getSmallestString(int n, int k) {
        int[] table = new int[n];
        
        Arrays.fill(table, 1);
        
        k = k - n;
        
        for (int i = n - 1; i >= 0; i--) {
            int code = Math.min(k, 25);
            table[i] = code;
            k -= code;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int c: table) {
            sb.append((char)((int)('a') + c));
        }
        
        return sb.toString();
    }
}
