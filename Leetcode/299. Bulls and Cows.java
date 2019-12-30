class Solution {
  public String getHint(String secret, String guess) {
      int A = 0;
      int B = 0;
      boolean[] visited = new boolean[secret.length()];
      
      Map<Character, Integer> map = new HashMap<>();
      
      for (char c: secret.toCharArray()) {
          map.put(c, map.getOrDefault(c, 0) + 1);
      }
      
      for (int i = 0; i < secret.length(); i++) {
          char s = secret.charAt(i);
          char g = guess.charAt(i);
          
          if (!map.containsKey(g)) { continue; }
          
          if (s == g) {
              if (map.get(s) > 0) {
                  visited[i] = true;
                  map.put(s, map.get(s) - 1);
                  A++;
              } 
          }
      }
      
      for (int i = 0; i < secret.length(); i++) {
          if (visited[i]) { continue; }
          char s = secret.charAt(i);
          char g = guess.charAt(i);
          
          if (!map.containsKey(g)) { continue; }
          
          if (s != g) {
              if (map.get(g) > 0) {
                  map.put(g, map.get(g) - 1);
                  B++;
              } 
          }
      }
      
      return "" + A + "A" + B + "B";
  }
}