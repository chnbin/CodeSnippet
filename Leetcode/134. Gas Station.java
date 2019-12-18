class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
      int consume = 0; 
      int debt = 0;
      int start = 0;
      
      for (int i = 0; i < gas.length; i++) {
          consume += (gas[i] - cost[i]);
          debt += (gas[i] - cost[i]);
          
          // 如果中間一段路就沒有油了，代表要從下一個位置當起點
          if (debt < 0) {
              debt = 0;
              start = i + 1;
          }
      }
      
      // 如果整段路的消耗變成負數，代表油根本不夠
      return (consume < 0) ? -1 : start;
  }
}