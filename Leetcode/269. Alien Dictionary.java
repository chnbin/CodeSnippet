import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
  public String alienOrder(String[] words) {
  StringBuilder res = new StringBuilder();
  Map<Character, ArrayList<Character>> graph = new HashMap<Character, ArrayList<Character>>();
  Map<Character, Integer> inDegree = new HashMap<>();
  Queue<Character> queue = new LinkedList<>();
  
      // Generate graph from all characters
      // ["ab", "adc"]
  for (String word: words) {
    for (char c: word.toCharArray()) {
      if (!graph.containsKey(c)) {
        graph.put(c, new ArrayList<Character>());
      }
      if (!inDegree.containsKey(c)) {
        inDegree.put(c, 0);
      }
    }
  }
  
  // To build an graph from words
  for (int i = 1; i < words.length; i++) {
    String word1 = words[i-1];
    String word2 = words[i];
    int pos = 0;
    
    while (pos < word1.length() && pos < word2.length()) {
      char c1 = word1.charAt(pos);
      char c2 = word2.charAt(pos);
      
      if (c1 != c2) {
        // c1 -> c2
        graph.get(c1).add(c2);
        
        // 2. Compute in-degree
        inDegree.put(c2, inDegree.get(c2) + 1);
        
        pos = word1.length();
      }
      pos++;
    }
  }
  
  // Put node to queue.
  for (char c: inDegree.keySet()) {
    if (inDegree.get(c) == 0) {
      queue.offer(c);
    }
  }
  
  while (!queue.isEmpty()) {
    int size = queue.size();
    
    for (int i = 0; i < size; i++) {
      char node = queue.poll();
      res.append(node);
      
      for (int j = 0; j < graph.get(node).size(); j++) {
        char neighbor = graph.get(node).get(j);
        inDegree.put(neighbor, inDegree.get(neighbor) - 1);
        if (inDegree.get(neighbor) == 0) {
          queue.offer(neighbor);
        }
      }
    }
  }
  
  if (res.length() != (inDegree.size())) {
    return "";
  }
  
  return res.toString();
}
}