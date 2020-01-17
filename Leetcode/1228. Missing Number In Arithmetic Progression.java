class Solution {
  public int missingNumber(int[] arr) {
      int diff = arr[1] - arr[0];
      
      if (diff == 0) { return arr[0]; }
      
      Set<Integer> set = new HashSet<>();
      set.add(arr[0]);
      set.add(arr[1]);
      set.add(arr[arr.length - 1]);
      
      for (int i = 2; i < arr.length; i++) {
          set.add(arr[i]);
          if (diff > 0) {
              if ((arr[i] - arr[i - 1]) < diff) {
                  diff = arr[i] - arr[i - 1];
              }
          } else {
              if ((arr[i] - arr[i - 1]) > diff) {
                  diff = arr[i] - arr[i - 1];
              }
          }
      }
      
      if (diff > 0) {
          for (int i = arr[0]; i <= arr[arr.length - 1]; i = i + diff) {
              if (!set.contains(i)) {
                  return i;
              }
          }
      } else {
          for (int i = arr[0]; i >= arr[arr.length - 1]; i = i + diff) {
              if (!set.contains(i)) {
                  return i;
              }
          }
      }
      
      return -1;
  }
}