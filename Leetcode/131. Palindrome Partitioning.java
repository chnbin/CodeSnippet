class Solution {
  public List<List<String>> partition(String s) {
      List<List<String>> res = new ArrayList<>();
      if (s == null || s.length() == 0) { return res; }
      
      List<String> tmpAns = new ArrayList<>();
      partitionHelper(res, tmpAns, s, 0, s.length());
      return res;
  }
  
  private void partitionHelper(List<List<String>> res,
                               List<String> tmpAns,
                               String s, int start, int end) {
      if (start == end) {
          res.add(new ArrayList<>(tmpAns));
          return;
      }
      
      for (int i = start; i < end; i++) {
          if (isPalindrome(s, start, i)) {
              tmpAns.add(s.substring(start, i + 1));
              partitionHelper(res, tmpAns, s, i + 1, end);
              tmpAns.remove(tmpAns.size() - 1);
          }
      }
  }
  
  private boolean isPalindrome(String s, int left, int right) {        
      while (left < right) {
          if (s.charAt(left) != s.charAt(right)) {
              return false;
          }
          left++;
          right--;
      }
      
      return true;
  }
}