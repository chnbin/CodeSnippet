class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] table = new int[5]; // For storing CROAK
        int frogs = 0;
        int max_frogs = 0;
        
        String croak = "croak";
        
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            int idx = croak.indexOf(ch);
            table[idx]++;
            
            if (idx == 0) {
                frogs++;
                max_frogs = Math.max(max_frogs, frogs);
            } else if (--table[idx -1] < 0) {
                return -1;
            } else if (idx == 4) {
                frogs--;
            }
        }
        
        return frogs != 0 ? -1 : max_frogs;
    }
}