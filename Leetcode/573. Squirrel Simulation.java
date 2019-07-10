class Solution {
  public int minDistance(int height, int width, int[] tree, int[] sqr, int[][] nuts) {
      int route = 0;
      int minDiff = height + width;
      for(int[] pos : nuts) {
          //sum of mahattan distance of every nuts to tree * 2
          route += 2 * (dist(pos, tree));
          //distance from squirrel to first nut - distance from first nut to tree
          int diff = dist(pos, sqr) - dist(pos, tree);
          if(diff < minDiff) {
              minDiff = diff;
          }
      }
      route = route + minDiff;
      return route;
  }
  public int dist(int[] p1, int[] p2) {
      return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
  } 
}