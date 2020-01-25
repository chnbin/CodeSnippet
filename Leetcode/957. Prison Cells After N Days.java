class Solution {
  public int[] prisonAfterNDays(int[] cells, int N) {
      int cellSize = 8;
      for (N = ((N - 1) % 14) + 1; N > 0; N--) {
          int[] tmp = new int[cellSize];
          for (int i = 1; i < 7; i++) {
              if ((cells[i-1] == 0 && cells[i+1] == 0) || ((cells[i-1] == 1 && cells[i+1] == 1))) {
                  tmp[i] = 1;
              } else {
                  tmp[i] = 0;
              }
          }
          cells = tmp;
      }
      return cells;
  }
}