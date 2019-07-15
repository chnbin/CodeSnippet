import java.util.List;

class Solution {
  public boolean validWordSquare(List<String> words) {
      /*
        Consider this case
        ball
        asee
        let
        lep
      */
      if (words == null || words.size() == 0) { return true; }
      if (words.size() != words.get(0).length()) { return false;}
      
      for (int i = 0; i < words.size(); i++) {
          for (int j = 0; j < words.get(i).length(); j++) {
              if (j >= words.size() ||i >= words.get(j).length() ||
                  words.get(i).charAt(j) != words.get(j).charAt(i)) {
                  return false;
              }
          }
      }

      return true;
  }
}