import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[][] intervalIntersection(int[][] A, int[][] B) {
      List<int[]> res = new ArrayList<>();
      int pA = 0;
      int pB = 0;
      
      while (pA < A.length && pB < B.length) {
          // 先取區間
          // low - the start of the intersection
          // hiht - the end of the intersection
          int low = Math.max(A[pA][0], B[pB][0]);
          int high = Math.min(A[pA][1], B[pB][1]);
          
          if (low <= high) {
              int[] inter = {low, high};
              res.add(inter);
          }
          
          // Remove the intervel with the smaller end
          if (A[pA][1] < B[pB][1]) {
              pA++;
          } else {
              pB++;
          }
      }
      
      int[][] ans = new int[res.size()][2];
      
      for (int i = 0; i < res.size(); i++) {
          ans[i][0] = res.get(i)[0];
          ans[i][1] = res.get(i)[1];
      }
      return ans;
  }
}