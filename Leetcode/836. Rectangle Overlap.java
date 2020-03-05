class Solution {
  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
      /*
          Interval A = [leftA, rightA]
          Interval B = [leftB, rightB]
          Overlapping region:  [max(leftA, leftB) , min(rightA, rightB)]                 
          which means if(max(leftA, leftB) < min(rightA, rightB)), there is an overlap.
      */
      
      int x1 = rec1[0], x2 = rec1[2], y1 = rec1[1], y2 = rec1[3];
      int x3 = rec2[0], x4 = rec2[2], y3 = rec2[1], y4 = rec2[3];
      
      boolean isOverlapX = (Math.max(x1, x3) < Math.min(x2, x4)) ? true :false;
      boolean isOverlapY = (Math.max(y1, y3) < Math.min(y2, y4)) ? true :false;
      
      return isOverlapX && isOverlapY;
  }
}