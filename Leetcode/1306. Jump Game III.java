class Solution {
  public boolean canReach(int[] arr, int start) {
      boolean[] visited = new boolean[arr.length];
      Queue<Integer> q = new LinkedList<>();
      q.offer(start);
      visited[start] = true;
      
      while (!q.isEmpty()) {
          int size = q.size();
          
          for (int i = 0; i < size; i++) {
              int pos = q.poll();
              if (arr[pos] == 0) {
                  return true;
              }
              
              int left = pos + arr[pos];
              int right = pos - arr[pos];
              
              if (left >= 0 && left < arr.length && !visited[left]) {
                  q.offer(left);
                  visited[left] = true;
              }
              
              if (right >= 0 && right < arr.length && !visited[right]) {
                  q.offer(right);
                  visited[right] = true;
              }
          }
      }
      
      return false;
  }
}
