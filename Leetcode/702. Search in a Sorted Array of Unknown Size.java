class Solution {
  public int search(ArrayReader reader, int target) {
      int left = 0;
      int right = Integer.MAX_VALUE;
      
      while (left <= right) {
          int mid = left + (right - left) / 2;
          
          if (reader.get(mid) == Integer.MAX_VALUE) {
              right = mid - 1;
          } else {
              if (reader.get(mid) == target) {
                  return mid;
              } else if (reader.get(mid) > target) {
                  right = mid - 1;
              } else {
                  left = mid + 1;
              }
          }
      }
      
      return -1;
  }
}

// A fake class...
class ArrayReader {
  public int get(int i) {
    return i;
  }
}