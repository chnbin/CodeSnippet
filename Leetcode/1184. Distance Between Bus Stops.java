class Solution {
  public int distanceBetweenBusStops(int[] distance, int start, int destination) {
      int totalDistance = 0;
      int sTod = 0;
      
      for (int d: distance) {
          totalDistance += d;
      }
      if (start > destination) {
          int tmp = start;
          start = destination;
          destination = tmp;
      }
      
      for (int i = start; i < destination; i++) {
          sTod += distance[i];
      }
      
      return Math.min(sTod, totalDistance - sTod);
  }
  
}