class Solution {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      boolean[] visited = new boolean[rooms.size()];
      dfs(rooms, 0, visited);
      
      for (int i = 0; i < visited.length; i++) {
          if (!visited[i]) { return false; }
      }
      return true;
  }
  
  private void dfs(List<List<Integer>> rooms, int roomNo, boolean[] visited) {
      if (visited[roomNo]) {
          return ;
      }
      
      visited[roomNo] = true;
      // Get all keys from roomNo
      List<Integer> keys = rooms.get(roomNo);
      
      for (int i = 0; i < keys.size(); i++) {
          // Use key to open another room;
          int key = keys.get(i);
          dfs(rooms, key, visited);
      }
  }
}