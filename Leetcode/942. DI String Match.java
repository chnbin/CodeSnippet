class Solution {
  public int[] diStringMatch(String S) {
      int[] array = new int[S.length()+1];
      int[] ans = new int[array.length];
      
      for (int i = 0; i < array.length; i++) {
          array[i] = i;
      }
      
      int left = 0;
      int right = array.length - 1;
      int pos = 0;
      for (char c: S.toCharArray()) {
          if (c == 'I') {
              ans[pos] = array[left];
              left++;
          } else {
              ans[pos] = array[right];
              right--;
          }
          pos++;
      }
      ans[ans.length-1] = array[left];
      return ans;
  }
}