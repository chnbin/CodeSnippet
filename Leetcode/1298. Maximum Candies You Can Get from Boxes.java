class Solution {
  public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
      int n = status.length;
      boolean[] gotBoxes = new boolean[n]; // Record boxes we got.
      boolean[] gotKeys = new boolean[n]; // Record keys we got.
      boolean[] opend = new boolean[n];
      int res = 0;
      Queue<Integer> q = new LinkedList<>(); // Opend box will be put into queue.
      
      for (int initialBox: initialBoxes) {
          if (status[initialBox] == 1) {
              q.offer(initialBox);
          }
          gotBoxes[initialBox] = true;
      }
      
      while (!q.isEmpty()) {
          int size = q.size();
          
          // Open all boxes we can open, collect all keys and candies
          for (int i = 0; i < size; i++) {
              int box = q.poll();
              
              // Get candies
              res += candies[box];
              opend[box] = true;
              
              // Get containBoxes
              for (int j = 0; j < containedBoxes[box].length; j++) {
                  gotBoxes[containedBoxes[box][j]] = true;
              }
              /*for (int[] containedBox: containedBoxes[box]) {
                  gotBoxes[containedBox] = true;
              }*/
              
              // Get Key
              for (int k = 0; k < keys[box].length; k++) {
                  gotKeys[keys[box][k]] = true;
              }
              /*
              for (int[] key: keys[box]) {
                  gotKeys[key] = true;
              }*/
          }
          
          // Check if we can open boxes with keys.
          for (int i = 0; i < n; i++) {
              if (((gotBoxes[i] && status[i] == 1) || (gotBoxes[i] && gotKeys[i])) && !opend[i]) {
                  q.offer(i);
                  gotBoxes[i] = false;
                  gotKeys[i] = false;
              }
          }
      }
      
      return res;
  }
}