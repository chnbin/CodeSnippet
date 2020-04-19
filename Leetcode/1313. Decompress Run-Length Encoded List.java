class Solution {
  public int[] decompressRLElist(int[] nums) {
      int n = nums.length;
      List<Integer> num = new ArrayList<>();
      int pos = 0;
      for(int i = 0; i <= n - 2; i++) {

          if ((i*2) > n - 1 || (2*i - 1) > n - 1) {
              break;
          }
          
          int a = nums[i*2];
          int b = nums[2*i + 1];
          while (a > 0) {
              num.add(b);
              a--;
          }
      }
      int[] res = new int[num.size()];
      
      for (int i = 0; i < num.size(); i++) {
          res[i] = num.get(i);
      }
      return res;
  }
}
