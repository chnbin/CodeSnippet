class Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
      int index1 = -1; // Recent postion of word1, -1 means not appear yet.
      int index2 = -1; // Recent postion of word2, -1 means not appear yet.
      int res = Integer.MAX_VALUE;
      
      // For each word1, we need to get the recent position of word2.
      // For each word2, we need to get the recent position of word1.
      for (int i = 0; i < words.length; i++) {
          String word = words[i];
          
          if (word.equals(word1)) {
              if (index2 != -1) {
                  res = Math.min(res, i - index2);
              }
              index1 = i;
          } else if (word.equals(word2)) {
              if (index1 != -1) {
                  res = Math.min(res, i - index1);
              }
              index2 = i;
          }
      }
      return (res == Integer.MAX_VALUE) ? -1 : res;
  }
}