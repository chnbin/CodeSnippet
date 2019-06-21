import java.util.List;

class ZigzagIterator {
  private int[] zigzagArray;
  private int pos;
  private int len;
  private int idx;
  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
      int len1 = v1.size();
      int len2 = v2.size();
      pos = 0;
      idx = 0;
      len = len1 + len2;
      
      zigzagArray = new int[len];
      
      int m = 0;
      int n = 0;
      
      while (m < len1 || m < len2) {
          if (m < len1) {
              zigzagArray[pos++] = v1.get(m);
          }
          
          if (m < len2) {
              zigzagArray[pos++] = v2.get(m);
          }
          m++;
      }
      //System.out.println(Arrays.toString(zigzagArray));
  }

  public int next() {
      return zigzagArray[idx++];
  }

  public boolean hasNext() {
      return (idx < len);
  }
}

/**
* Your ZigzagIterator object will be instantiated and called as such:
* ZigzagIterator i = new ZigzagIterator(v1, v2);
* while (i.hasNext()) v[f()] = i.next();
*/