class Solution {
  public int[] xorQueries(int[] arr, int[][] queries) {
      /*
          a ^ a = 0
          [0001, 0010, 0110, 1110]
           a     a^b   a^b^c a^b^c^d
           
           q[m, n] =    n      ^ m -1
           q[1, 1] = (a^b)     ^ (a)
           q[2, 3] = (a^b^c^d) ^ (a^b)
      */
      int[] prefix = new int[arr.length];
      int[] res = new int[queries.length];

      prefix[0] = arr[0];
      
      for (int i = 1; i < arr.length; i++) {
          prefix[i] = prefix[i-1] ^ arr[i];
      }
      
      for (int i = 0; i < queries.length; i++) {
          int m = queries[i][0];
          int n = queries[i][1];
          
          int result = prefix[n];
          if (m - 1 >= 0) {
              result ^= prefix[m - 1];
          }
          res[i] = result;
      }
      return res;
  }
}