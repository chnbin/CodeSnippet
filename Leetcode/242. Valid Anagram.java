import java.util.Arrays;

class Solution {
  public boolean isAnagram(String s, String t) {
      int[] nums = new int[26];
      if (s.length() != t.length()) { return false; }
      
      for (int i = 0; i < s.length(); i++) {
          nums[s.charAt(i) - 'a']++;
          nums[t.charAt(i) - 'a']--;
      }
      
      for (int num: nums) {
          if (num != 0) { return false; }
      }
      
      return true;
  }

  public boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) { return false; }
    
    char[] s1 = s.toCharArray();
    char[] s2 = t.toCharArray();
    
    Arrays.sort(s1);
    Arrays.sort(s2);
    
    return Arrays.equals(s1, s2);

}
}