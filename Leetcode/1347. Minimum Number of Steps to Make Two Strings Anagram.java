class Solution {
  public int minSteps(String s, String t) {
      int res = 0;
      char[] tableS = new char[26];
      char[] tableT = new char[26];
      
      for (int i = 0; i < s.length(); i++) {
          tableS[s.charAt(i) - 'a']++;
          tableT[t.charAt(i) - 'a']++;
      }
      
      for (int i = 0; i < 26; i++) {
          res += Math.abs(tableS[i] - tableT[i]);
      }
      
      return res/2;
  }
}
