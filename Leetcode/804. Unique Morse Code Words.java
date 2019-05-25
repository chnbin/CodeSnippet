import java.util.HashSet;
import java.util.Set;

class Solution {
  public int uniqueMorseRepresentations(String[] words) {
      String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.",
                            "....","..",".---","-.-",".-..","--","-.",
                            "---",".--.","--.-",".-.","...","-","..-",
                            "...-",".--","-..-","-.--","--.."};
      Set<String> set = new HashSet<>();
      
      for (String word: words) {
          String code = "";
          for (char c: word.toCharArray()) {
              code += morseCode[c-'a'];
          }
          set.add(code);
      }
      return set.size();
  }
}