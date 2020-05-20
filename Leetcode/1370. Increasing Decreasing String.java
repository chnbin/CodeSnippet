class Solution {
  /*
    Time comlexity: O(n) where n is the length of s.
    First, we count the frequency of each character.
    Step 1: scan frequency from 'a' to 'z'. If frequency of character is bigger than zero, append this character to answer.
    Step 2: scan frequency from 'z' to 'a'. If frequency of character is bigger than zero, append this character to answer.
    Do step1 and step2 repeatly until we use all characters.
   */
  public String sortString(String s) {
    String res = "";
    int[] tables = new int[26];
    int n = s.length();
    
    for (char c: s.toCharArray()) {
        tables[c - 'a']++;
    }
    
    while (n > 0) {
        // Step 1
        for (int i = 0; i < 26; i++) {
            if (tables[i] > 0) {
                tables[i]--;
                res += (char)(i + 'a');
                n--;
            }
        }
        // Step 2
        for (int i = 25; i >= 0; i--) {
            if (tables[i] > 0) {
                tables[i]--;
                res += (char)(i + 'a');
                n--;
            }
        }
    }
    
    return res;
  }
}
