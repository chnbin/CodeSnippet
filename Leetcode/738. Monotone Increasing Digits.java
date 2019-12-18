class Solution {
  public int monotoneIncreasingDigits(int N) {
      if (N < 10) { return N; }
      char[] str = Integer.toString(N).toCharArray();
      int n = str.length;
      int pos = n;
      
      for (int i = n - 1; i > 0; i--) {
          if (str[i - 1] <= str[i]) { continue; }
          str[i - 1]--;
          pos = i;
      }
      
      for (int i = pos; i < n; i++) {
          str[i] = '9';
      }
      
      return Integer.parseInt(new String(str));
  }
}