/*
    Biweekly Contest 25
    https://leetcode.com/contest/biweekly-contest-25
    Easy problem.
*/
    
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] s = s1.toCharArray();
        char[] t = s2.toCharArray();
        
        Arrays.sort(s);
        Arrays.sort(t);
        
        boolean allUpper = true;
        boolean allLower = true;
        
        for (int i = 0; i < s.length; i++) {
            if (s[i] < t[i]) {
                allUpper = false;
                break;
            }
        }
        
        for (int i = 0; i < s.length; i++) {
            if (s[i] > t[i]) {
                allLower = false;
                break;
            }
        }
        
        return allUpper || allLower;
    }
}
