class Solution {
    // 注意題目，以B=["eo","oo"]為例，其eo中e與o出現了1次，oo出現兩次。
    // 因此答案的字串一定要有一個e，二個oo
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] table = new int[26];
        List<String> res = new ArrayList<>();
        
        for (String s: B) {
            int[] tmp = new int[26];
            for (char c: s.toCharArray()) {
                tmp[c - 'a']++;
            }
            
            for (int i = 0; i < 26; i++) {
                table[i] = Math.max(table[i], tmp[i]);
            }
        }
        
        for (String s: A) {
            int[] cnt = table.clone();
            for (char c: s.toCharArray()) {
                if (cnt[c - 'a'] > 0) {
                    cnt[c - 'a'] -= 1;
                }
            }
            if (remainCharCount(cnt) == 0) {
                res.add(s);
            }
        }
        
        return res;
    }
    
    private int remainCharCount(int[] table) {
        int res = 0;
        
        for (int num: table) {
            res += num;
        }
        
        return res;
    }
}
