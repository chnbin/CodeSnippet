class Solution {
    public int minOperations(String[] logs) {
        int res = 0;
        
        for (String log: logs) {
            if (log.indexOf("..") != -1 && res != 0) {
                res--;
            } else if (log.indexOf(".") != -1) {
                continue;
            } else {
                res++;
            }
        }
        
        
        return res;
    }
}
