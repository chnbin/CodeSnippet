class Solution {
  public boolean carPooling(int[][] trips, int capacity) {
      int[] locations = new int[1001];
      
      for (int i = 0; i < trips.length; i++) {
          int passenger = trips[i][0];
          int start = trips[i][1];
          int end = trips[i][2];
          locations[start] += passenger;
          locations[end] -= passenger;
      }
      
      for (int i = 1; i < locations.length; i++) {
          locations[i] += locations[i - 1];
      }
      
      for (int i = 1; i < locations.length; i++) {
          if (locations[i] > capacity) { return false; }
      }
      
      return true;
  }
}