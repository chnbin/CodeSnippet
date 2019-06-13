class Solution {
  public String reverseWords(String s) {
      if (s == null || s.length() == 0) { return ""; }
      StringBuilder res = new StringBuilder();
      
      while (s.indexOf(" ") != -1) {
          int index = s.indexOf(" ");
          res.append(reverseString(s.substring(0, index).toCharArray() , 0, index - 1));
          res.append(" ");
          s = s.substring(index + 1, s.length());
          // System.out.println(s);
      }
      res.append(reverseString(s.toCharArray(), 0, s.length() - 1));
      return res.toString();
  }
  
  private String reverseString(char[] array, int left, int right) {
      while (left < right) {
          char tmp = array[left];
          array[left] = array[right];
          array[right] = tmp;
          left++;
          right--;
      }
      return new String(array);
  }
}