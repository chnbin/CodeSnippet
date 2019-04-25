import java.util.HashMap;
import java.util.Map;

class Solution {
  public int subarraysWithKDistinct(int[] A, int K) {
      return helper(A, K) - helper(A, K -1);
  }
  
  public int helper(int[] A, int K) {
      if (A == null || A.length == 0) { return 0; }
          int start = 0;
          int end =0;
          int counter = 0;
          int ans = 0;
          Map<Integer, Integer> map = new HashMap<Integer, Integer>();

          while (end < A.length) {
              int endNum = A[end];
              if (map.containsKey(endNum)) {
                  map.put(endNum, map.get(endNum)+1);
              } else {
                  map.put(endNum, 1);
              }

              if (map.get(endNum) == 1) {
                  counter++;
              }
              end++;

              while (counter > K) {
                  int startNum = A[start];
                  if (map.containsKey(startNum)) {
                      map.put(startNum, map.get(startNum) - 1);
                      if (map.get(startNum) == 0) {
                          counter--;
                      }
                  }
                  start++;
              }
              ans += (end - start + 1);
          }
          return ans;
      }
}