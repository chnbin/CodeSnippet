class Solution {
  public String reverseStr(String s, int k) {
      int n = s.length();
      if (k > n) { k = n; }
      int pos = 0;
      
      while (pos < n) {
          if (pos + k - 1 < n) {
             s = reverseString(s, pos, pos + k - 1);
          } else {
             s = reverseString(s, pos, n - 1);
          }
          pos += (2*k);
      }
      return s;
  }
  
  private String reverseString(String str, int left, int right) {
      char[] arr = str.toCharArray();
      
      while (left < right) {
          char tmp = arr[left];
          arr[left] = arr[right];
          arr[right] = tmp;
          
          left++;
          right--;
      }
      return new String(arr);
  }
}