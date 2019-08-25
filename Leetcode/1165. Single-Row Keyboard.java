class Solution {
  public int calculateTime(String keyboard, String word) {
      int[] index = new int[26];
      
      for (int i = 0; i < keyboard.length(); i++) {
          char c = keyboard.charAt(i);
          index[c - 'a'] = i;
      }
      
      int res = 0;
      int pos = 0;
      
      for (int i = 0; i < word.length(); i++) {
          int currPos = index[word.charAt(i) - 'a'];
          res += Math.abs(currPos - pos);
          pos = currPos;
      }
      return res;
  }
}