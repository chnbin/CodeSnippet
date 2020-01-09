class Solution {
  public List<Integer> powerfulIntegers(int x, int y, int bound) {
      /*
          忘了log不可以以1為底，數學上無意義。
          Math.log(1) -> 2147483647，將會導致超時。
      */
      int xPow = (x == 1) ? 1 : (int)Math.ceil(Math.log(bound * 1.0) / Math.log(x * 1.0));
      int yPow = (y == 1) ? 1 : (int)Math.ceil(Math.log(bound * 1.0) / Math.log(y * 1.0));
      int x1 = (int)Math.ceil(Math.log(bound * 1.0) / Math.log(1.0));
      List<Integer> res = new ArrayList<>();
      Set<Integer> set = new HashSet<>();
      
      for (int i = 0; i < xPow; i++) {
          for (int j = 0; j < yPow; j++) {
              int sol = (int)(Math.pow(x, i * 1.0) + Math.pow(y, j * 1.0));
              if (!set.contains(sol) && sol <= bound) {
                  res.add(sol);
                  set.add(sol);
              }
          }
      }
      
      return res;
  }
}