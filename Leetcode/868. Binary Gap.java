class Solution {
  public int binaryGap(int N) {
      /*
        Step 1: Keep recording the position of One and add position into list.
                Ex. 65535 -> 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
                       22 -> 1, 2, 4
        Step 2: Then we can find the largest distance.
        Time / Space Complexity: O(logN)
      */
      List<Integer> positionOfOne = new ArrayList<>();
      int res = 0;
      int pos = 0;
      
      while (N > 0) {
          if ((N & 1) == 1) {
              positionOfOne.add(pos);
              // System.out.println(pos);
          }
          pos++;
          N >>= 1;
      }
      
      if (positionOfOne.size() < 2) { return 0; }
      
      for (int i = 1; i < positionOfOne.size(); i++) {
          res = Math.max(res, positionOfOne.get(i) - positionOfOne.get(i - 1));
      }
      
      return res;
  }
}
