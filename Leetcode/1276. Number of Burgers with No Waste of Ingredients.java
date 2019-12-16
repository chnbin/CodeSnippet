class Solution {
  public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
      // J is total number of jumbo burgers, S is total number of small burgers.
      // 4J + 2S = tomatoSlices
      // J + S = cheeseSlices
      // Then
      // 2J = tomatoSlices - 2cheeseSlices
      // J = (tomatoSlices / 2) - cheeseSlices
      // S = cheeseSlices - J
      int J = (tomatoSlices / 2) - cheeseSlices;
      int S = cheeseSlices - J;
      List<Integer> res = new ArrayList<>();
      
      if (tomatoSlices % 2 == 0 && J >= 0 && S >= 0) {
          res.add(J);
          res.add(S);
      }
      
      return res;
  }
}