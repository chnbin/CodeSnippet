class Solution {
  public int[] getStrongest(int[] arr, int k) {
      // 6 6 7 7 8 11
      Arrays.sort(arr);
      int m = arr[(arr.length - 1)/2];
      List<Integer> order = new ArrayList<>();
      int left = 0;
      int right = arr.length - 1;
      
      while (k > 0) {
          if (Math.abs(arr[left] - m) > Math.abs(arr[right] - m)) {
              order.add(arr[left]);
              left++;
          } else {
              order.add(arr[right]);
              right--;
          }
          k--;
      }
      int[] res = new int[order.size()];
      for (int i = 0; i < order.size(); i++) {
          res[i] = order.get(i);
      }
      return res;
  }
}
