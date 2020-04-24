class Solution {
  public int[] processQueries(int[] queries, int m) {
      int nums[] = new int[m + 1];
      int res[] = new int[queries.length];
      
      /* 
          我們可以維護一個整數陣列pos[]，記錄當前所有數字的位置
          初始時數字的位置對應其本身的數值減一
      */
      for (int i = 1; i <= m; i++) {
          nums[i] = i - 1;
      }
      
      /*
          接下來我們循環 queries 中的每一個數字，利用pos數組查看當前數字所在的位置，
          並將該位置計入返回結果。
          然後，由於當前數字從當前位置移動到陣列的起點因此當前數字的位置變為0
          其他小於當前數字的位置都要加一，位置大於當前數字的位置保持不變。
          重複此步驟，直到循環完所有 queries 中的數字。
      */
      for (int i = 0; i < queries.length; i++) {
          int query = queries[i];
          int index = nums[query];
          res[i] = index;
          
          for (int j = 1; j <= m; j++) {
              if (nums[j] < index) {
                  nums[j]++;
              }
          }
          nums[query] = 0;
      }
      return res;
  }
}
