class Solution {
  public int findKthNumber(int n, int k) {
      long currMax = 1;
      k--;
      
      while (k > 0) {
          int childNodeCount = getChildNodeCount(currMax, n);
          
          // k 比childNodeCount還多代表直接往右邊移動了，例如直接由1移動到2
          if (k > childNodeCount) {
              // 先扣掉所有子樹的數量(例如：n=15, k = 8時1的子節點數)
              k -= childNodeCount;
              // 再扣掉目標的數量(例如：n=15, k = 8時 由1移動到2，2本身的數量，就是1)
              k -= 1;
              currMax++;
          } else {
              // k 比childNodeCount還少代表直接往下移動例如由1 -> 10
              k--;
              currMax *= 10;
          }
      }
      
      return (int)currMax;
  }
  
  private int getChildNodeCount(long curr, int n) {
      // 目前最大的子節點
      long maxChild = curr;
      // 目前層數理論上最大的點數
      long maxChildCount = 1;
      // 目前有多少個子結點
      long childrenCount = 0;
      
      while (curr*10 <= n) {
          // 往下一層，因此子節點增加10倍
          maxChildCount *= 10;
          
          // 更新所有子節點的數量
          childrenCount += maxChildCount;
          
          // 更新目前最大子節點
          maxChild = maxChild*10 +9;
          
          // 如果目前最大子節點比n還大，那得扣掉多出來的那些
          if (maxChild > n) {
              childrenCount = childrenCount - (maxChild - n);
          }
          curr *= 10;
      }
      
      return (int)childrenCount;
  }
}