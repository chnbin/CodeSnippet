class Solution {
  public int[] kWeakestRows(int[][] mat, int k) {
      int[] res = new int[k];
      
      // element 0 is index, 1 is weakness
      int[][] rowWeak = new int[mat.length][2];
      
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
          if (a[1] == b[1]) {
              return a[0] - b[0];
          }
          
          return a[1] - b[1];
      });
      
      for (int i = 0; i < mat.length; i++) {
          int weakness = countWeakness(mat[i]);
          // System.out.println(weakness);
          int[] tmp = new int[2];
          tmp[0] = i;
          tmp[1] = weakness;
          pq.offer(tmp);
      }
      
      int pos = 0;
      
      while (pos < k && !pq.isEmpty()) {
          int[] tmp = pq.poll();
          res[pos] = tmp[0];
          pos++;
      }
      
      return res;
  }
  
  private int countWeakness(int[] row) {
      int left = 0;
      int right = row.length - 1;
      
      while (left <= right) {
          int mid = (left + right) / 2;
          
          if (row[mid] == 1) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }
      
      return left;
  }
}
