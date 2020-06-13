class SubrectangleQueries {
  // Brute force...
  int[][] rect;
  int m = 0;
  int n = 0;
  public SubrectangleQueries(int[][] rectangle) {
      this.rect = rectangle;
      this.m = rectangle.length;
      this.n = rectangle[0].length;
      
  }
  
  public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
      if (row1 < 0 || row1 > m || row2 < 0 || row2 > m || col1 < 0 || col1 > n || col2 < 0 || col2 > n) {
          return;
      }
      
      for (int i = row1; i <= row2; i++) {
          for (int j = col1; j <= col2; j++) {
              this.rect[i][j] = newValue;
          }
      }
  }
  
  public int getValue(int row, int col) {
      return this.rect[row][col];
  }
}

/**
* Your SubrectangleQueries object will be instantiated and called as such:
* SubrectangleQueries obj = new SubrectangleQueries(rectangle);
* obj.updateSubrectangle(row1,col1,row2,col2,newValue);
* int param_2 = obj.getValue(row,col);
*/
