class Solution {
  public double average(int[] salary) {
      if (salary == null || salary.length == 0) { return 0.0; }
      double max = Double.MIN_VALUE;
      double min = Double.MAX_VALUE;
      
      for (int s: salary) {
          max = Math.max(max, s);
          min = Math.min(min, s);
      }
      double res = 0.0;
      double n = 0.0;
      
      for (int s: salary) {
          if (s == max || s == min) {
              continue;
          }
          res += s;
          n += 1;
      }
      
      if (n == 0) { return 0; }
      
      return res/n;
  }
}
