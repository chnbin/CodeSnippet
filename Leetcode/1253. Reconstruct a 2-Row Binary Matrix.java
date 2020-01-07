class Solution {
  public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
      Integer[][] res = new Integer[2][colsum.length];
      
      for (int sum: colsum) {
          // 如果sum為二，則一定是upper與lower都剪掉1
          if (sum == 2) {
              if (--upper < 0 || --lower < 0) {
                  return new ArrayList<>();
              }
          }
      }
      
      for (int i = 0; i < colsum.length; i++) {
          int sum = colsum[i];
          
          // 列和為0，則上0下0
          if (sum == 0) {
              res[0][i] = 0;
              res[1][i] = 0;
          } else if (sum == 2) {
              // 列和為2，則上1下1
              res[0][i] = 1;
              res[1][i] = 1;
          } else {
              // 列和為1，則看upper與lower有剩的剪掉
              if (--upper >= 0) {
                  // upper有，則加到上面
                  res[0][i] = 1;
                  res[1][i] = 0;
              } else if (--lower >= 0) {
                  // lower有，則加到下面
                  res[0][i] = 0;
                  res[1][i] = 1;
              } else {
                  return new ArrayList<>();
              }
          }
      }
      
      // 若upper與lower有剩代表沒有可行答案
      if (upper > 0 || lower > 0) {
          return new ArrayList<>();
      }
      
      List<List<Integer>> ans = new ArrayList<>();
      ans.add(Arrays.asList(res[0]));
      ans.add(Arrays.asList(res[1]));
      return ans;
  }
}