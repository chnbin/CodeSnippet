import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Set<String> set = new HashSet<>(wordList);
      Queue<WordStep> queue = new LinkedList<>();
      queue.offer(new WordStep(beginWord, 1));
      
      while (!queue.isEmpty()) {
          WordStep ws = queue.poll();
          String currWord = ws.word;
          int step = ws.steps;
          
          if (currWord.equals(endWord)) {
              return step;
          }
          
          for (int i = 0; i < currWord.length(); i++) {
              for (int j = 'a'; j <= 'z'; j++) {
                  String candicate = currWord.substring(0, i) + (char)j + currWord.substring(i+1);
                  
                  if (set.contains(candicate)) {
                      set.remove(candicate);
                      queue.offer(new WordStep(candicate, step + 1));
                  }
              }
          }
      }
      
      return 0;
  }
}

class WordStep {
  String word;
  int steps;
  public WordStep (String word, int steps) {
      this.word = word;
      this.steps = steps;
  }
}