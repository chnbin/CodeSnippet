class Solution {
  public String reverseVowels(String s) {
      if (s.length() == 0) { return s; }
      
      char[] chars = s.toCharArray();
      String vowels = "auioeAUIOE";
      int left = 0;
      int right = s.length() - 1;
      
      while (left < right) {
          while (!vowels.contains(chars[left] + "") && (left < right)) {
              left++;
          }
          while (!vowels.contains(chars[right] + "") && (left < right)) {
              right--;
          }
          swap(chars, left, right); 
          left++;
          right--;
      }
      return  String.valueOf(chars);
      
  }
  
  public void swap(char[] array, int i, int j) {
      char tmp = array[i];
      array[i] = array[j];
      array[j] = tmp;
      
  }
  
}