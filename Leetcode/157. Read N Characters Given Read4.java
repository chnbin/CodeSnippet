public class Solution extends Reader4 {
  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return    The number of actual characters read
   */
  public int read(char[] buf, int n) {
      char[] buffer4 = new char[4];
      int pos = 0;
      
      while (pos < n) {
          int remain = read4(buffer4);
          if (remain == 0) { return pos; }
          
          for (int i = 0; i < remain && pos <n; i++) {
              buf[pos++] = buffer4[i];
          }
      }
      return pos;
  }

  // Fake, not real implementation of read4
  private int read4(char[] buf) {
    return buf.length;
  }
}