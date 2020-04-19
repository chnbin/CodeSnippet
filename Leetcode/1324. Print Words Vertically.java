class Solution {
  public List<String> printVertically(String s) {
      List<String> res = new ArrayList<>();
      String[] words = s.split(" ");
      int len = Integer.MIN_VALUE;
      
      for (String word: words) {
          len = Math.max(len, word.length());
      }
      
      for (int i = 0; i < len; i++) {
          StringBuilder sb = new StringBuilder();
          
          for (String word: words) {
              if (i < word.length()) {
                  sb.append("" + word.charAt(i));
              } else {
                  sb.append(" ");
              }
          }
          
          // Trim right
          int n = sb.length() - 1;
          while (sb.charAt(n) == ' ') {
              sb.deleteCharAt(n);
              n--;
          }
          res.add(sb.toString());
      }
      
      return res;
  } 
}
