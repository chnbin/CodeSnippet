class Solution {
  private int res = 0;
  public int maxScoreWords(String[] words, char[] letters, int[] score) {
      int[] alpha = new int[26];
      
      for (char c: letters) {
          alpha[c - 'a']++;
      }
      
      dfs(words, 0, words.length, alpha, 0, new ArrayList<String>(), score);
      return res;
  }
  
  private void dfs(String[] words, int start, int end, int[] alpha, int score, List<String> w, int[] scores) {
      if (start == end) {
          return;
      }
      
      for (int i = start; i < end; i++) {
          String word = words[i];
          if (isValid(word, alpha)) {
              removeArray(word, alpha);
              score += getScore(word, scores);
              res = Math.max(res, score);
              w.add(word);
              dfs(words, i + 1, end, alpha, score, w, scores);
              w.remove(w.size() - 1);
              score -= getScore(word, scores);
              recoverArray(word, alpha);
          }
      }
  }
  
  private boolean isValid(String str, int[] alpha) {
      int[] tmp = copyArray(alpha);
      
      for (char c: str.toCharArray()) {
          tmp[c - 'a']--;
          if (tmp[c - 'a'] < 0) {
              return false;
          }
      }
      return true;
  }
  
  private int[] copyArray(int[] arr) {
      int[] res = new int[arr.length];
      
      for (int i = 0; i < arr.length; i++) {
          res[i] = arr[i];
      }
      
      return res;
  }
  
  private int getScore(String str, int[] scores) {
      int sum = 0;
      
      for (char c: str.toCharArray()) {
          sum += scores[c - 'a'];
      }
      
      return sum;
  }
  
  private void removeArray(String str, int[] alpha) {
      for (char c: str.toCharArray()) {
          alpha[c - 'a']--;
      }
  }
  
  private void recoverArray(String str, int[] alpha) {
      for (char c: str.toCharArray()) {
          alpha[c - 'a']++;
      }
  }
}