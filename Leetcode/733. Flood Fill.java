class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      int targetColor = image[sr][sc];
      if (targetColor == newColor) { return image; }
      helper(image, sr, sc, targetColor, newColor);
      return image;
  }

  private void helper(int[][] image, int r, int c, int target, int newColor) {
      if ((0 <= r) && (r < image.length) && (0 <= c) && (c < image[0].length)) {
          if (image[r][c] == target) {
              image[r][c] = newColor;
              helper(image, r-1, c, target, newColor);
              helper(image, r+1, c, target, newColor);
              helper(image, r, c-1, target, newColor);
              helper(image, r, c+1, target, newColor);
          }
      }
  }
}