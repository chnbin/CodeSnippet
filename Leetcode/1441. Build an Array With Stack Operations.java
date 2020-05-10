class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int cnt = 1;
        
        Set<Integer> s = new HashSet<>();
        
        for (int i = 0; i < target.length; i++) {
            if (cnt == target[i]) {
                res.add("Push");
            } else {
                i--;
                res.add("Push");
                res.add("Pop");
            }
            
            cnt++;
        }
        
        return res;
    }
}
