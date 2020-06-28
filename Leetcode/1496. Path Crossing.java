class Solution {
  public boolean isPathCrossing(String path) {
      Set<String> set = new HashSet<>();
      set.add("0-0");
      int x = 0;
      int y = 0;
      
      for (int i = 0; i < path.length(); i++) {
          char c = path.charAt(i);
          if (c == 'N') {
              y++;  
          } else if (c == 'S') {
              y--;
          } else if (c == 'E') {
              x++;
          } else {
              x--;
          }
          String s = x + "-" + y;
              if (set.contains(s)) {
                  return true;
              }
              set.add(s);
      }
      
      return false;
  }
}
