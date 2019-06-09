import java.util.ArrayList;
import java.util.List;

class Solution {
  public String[] findOcurrences(String text, String first, String second) {
      List<String> res = new ArrayList<>();
      String[] words = text.split(" ");
      
      if (words.length < 3) { return new String[0]; }
      
      for (int i = 2; i < words.length; i++) {
          if (words[i-2].equals(first) && words[i-1].equals(second)) {
              res.add(words[i]);
          }
      }
      
      return res.toArray(new String[res.size()]);
  }
}