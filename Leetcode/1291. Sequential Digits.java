class Solution {
  public List<Integer> sequentialDigits(int low, int high) {
      List<Integer> res = new ArrayList<>();
      int minLen = String.valueOf(low).length();
      int maxLen = String.valueOf(high).length();
      
      String tmp = "123456789";
      
      while (minLen <= maxLen) {
          
          for (int i = 0, j = minLen; j <= tmp.length(); j++) {
              String s = tmp.substring(i, j);
              int c = Integer.parseInt(s);
              if (c > high) { break; }
              if (c >= low) {
                  res.add(c);
              }
              i++;
          }
          
          minLen++;
      }
      
      return res;
  }
}