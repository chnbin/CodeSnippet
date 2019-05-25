import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class WordDistance {
  private HashMap<String, ArrayList<Integer>> map;
  private Map<String, Integer> cache;

  public WordDistance(String[] words) {
      map = new HashMap<String, ArrayList<Integer>>();
      cache = new HashMap<String, Integer>();
      
      // Precomputation: indice of each word
      // ["practice", "makes", "perfect", "coding", "makes"]
      // practice => [0]
      // makes => [1, 4]
      // perfect => [2]
      for (int i = 0; i < words.length; i++) {
          String word = words[i];
          if (!map.containsKey(word)) {
              map.put(word, new ArrayList<Integer>());
          }
          map.get(word).add(i);
      }
  }
  
  public int shortest(String word1, String word2) {
      if (cache.containsKey(word1 + "-" + word2)) {
          return cache.get(word1 + "-" + word2);
      }

      int[] indice1 = getIntegerArray(map.get(word1));
      int[] indice2 = getIntegerArray(map.get(word2));
      int pos1 = 0, pos2 = 0;
      int res = Integer.MAX_VALUE;
      int index1 = -1, index2 = -1;

      while (pos1 < indice1.length && pos2 < indice2.length) {
          index1 = (pos1 < indice1.length) ? indice1[pos1] : index1;
          index2 = (pos2 < indice2.length) ? indice2[pos2] : index2;
          res = Math.min(res, Math.abs(index1 - index2));
          if (indice1[pos1] < indice2[pos2]) {
              pos1++;
          } else {
              pos2++;
          }
      }
      
      
      if (!cache.containsKey(word1 + "-" + word2)) {
          cache.put(word1 + "-" + word2, res);
      }
      return res;
  }
  
  private int[] getIntegerArray(ArrayList<Integer> list) {
      int[] res = new int[list.size()];
      
      for (int i = 0; i < list.size(); i++) {
          res[i] = list.get(i);
      }
      
      return res;
  }
}
