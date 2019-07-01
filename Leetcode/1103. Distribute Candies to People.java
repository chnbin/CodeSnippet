class Solution {
  public int[] distributeCandies(int candies, int num_people) {
      int[] res = new int[num_people];
      int pos = 0;
      
      while (candies > 0) {
          if (candies > (pos + 1)) {
              res[((pos) % num_people)] += (pos + 1);
              candies -= (pos + 1);
          } else {
              res[((pos) % num_people)] += candies;
              candies = 0;
          }
          pos++;
      }
      
      return res;
  }
}