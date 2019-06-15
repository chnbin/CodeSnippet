import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
     if (words1.length != words2.length) return false;

     Set<String> pairSet = new HashSet<>();
     for (int i = 0, len = pairs.size(); i < len; i++)
         pairSet.add(pairs.get(i).get(0) + "#" + pairs.get(i).get(1));

     for (int i = 0, len = words1.length; i < len; i++) {
         if (!words1[i].equals(words2[i]) &&
                 !pairSet.contains(words1[i] + "#" + words2[i]) &&
                 !pairSet.contains(words2[i] + "#" + words1[i]))
             return false;
     }
     return true;
 }
}