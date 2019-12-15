class Solution {
  public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
      List<List<Integer>> res = new ArrayList<>();
      
      for (int x = 1; x <= 1000; x++) {
          for (int y = 1; y <= 1000; y++) {
              if (customfunction.f(x, y) == z) {
                  List<Integer> ans = new ArrayList<>();
                  ans.add(x);
                  ans.add(y);
                  res.add(ans);
              }
          }
      }
      
      return res;
  }
}