class Solution {
  /*
      4: 0 1 0 0
     14: 1 1 1 0
      2: 0 0 1 0
      1: 0 0 0 1
     先看最後一列，有三個0和一個1，那麼它們之間相互的漢明距離就是3，即1和其他三個0分別的距離累加，然後看第三列，累加漢明距
     離為4，因為每個1都會跟兩個0產生兩個漢明距離，同理第二列也是4，第一列是3。
     仔細觀察累計漢明距離和0跟1的個數，可以發現其實就是0的個數乘以1的個數，發現了這個重要的規律，
     那麼整道題就迎刃而解了，只要統計出每一位的1的個數即可
  */
  public int totalHammingDistance(int[] nums) {
      int res = 0;
      int n = nums.length;
      
      for (int i = 0; i < 32; i++) {
          int cnt = 0; // count of 1
          
          for (int num: nums) {
              if (((num >>> i) & 1) == 1) {
                  cnt++;
              }
          }
          
          res += ((cnt) * (n - cnt));
      }
      
      return res;
  }
  
}