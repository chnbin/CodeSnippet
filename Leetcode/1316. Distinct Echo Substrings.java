class Solution {
  public int distinctEchoSubstrings(String text) {
      Set<String> set = new HashSet<>();
      int n = text.length();
      
      for (int i = 0; i < n; i++) {
          for (int j = i + 2; j <= n; j = j + 2) {
              if (isValid(text.substring(i, j))) {
                  set.add(text.substring(i, j));
              }
          }    
      }
      
      return set.size();
  }
  
  private boolean isValid(String str) {
      int n = str.length();
      String left = str.substring(0, n / 2);
      String right = str.substring(n / 2);
      return left.equals(right);
  }
}
