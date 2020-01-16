class Solution {
  public int numMatchingSubseq(String S, String[] words) {
      int res = 0;
      Set<String> set = new HashSet<>();

      for (int i = 0; i < words.length; i++) {
          if (set.contains(words[i])) {
              res++;
              continue;
          }
          
          char[] word = words[i].toCharArray();
          int pos = 0;
          for (int j = 0; j < S.length(); j++) {
              if (pos < word.length && word[pos] == S.charAt(j)) {
                  pos++;
              }
          }
          if (pos == word.length) {
              set.add(words[i]);
              res++;
          }
      }
      
      return res;
  }
}