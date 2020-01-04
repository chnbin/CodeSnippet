class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
      /*
        這道題給我們了一個數組，還有兩個變量k和x。讓找數組中離x最近的k個元素。而且說明了陣列已經排序。
        故兩個數字距離x相等的話，取較小的那個。
        從給定的例子可以分析出x不一定是數組中的數字，由於陣列有序，所以最後返回的k個元素也一定是有序的，
        本題就是就是返回了原陣列的一個長度為k的子陣列。
        轉化一下，實際上相當於在長度為n的陣列中去掉 n-k 個數字，而且去掉的順序肯定是從兩頭執行，
        因為距離x最遠的數字肯定在首尾出現。
        那麽問題就變的明朗了，每次比較首尾兩個數字跟x的距離，然後將距離大的那個數字刪除，直到陣列長度為k為止。
      */
      int left = 0;
      int right = arr.length - 1;
      List<Integer> res = new ArrayList<>();
      k = arr.length - k;
      
      while (k > 0) {
          if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
              right--;
          } else {
              left++;
          }
          k--;
      }
      
      for (int i = left; i <= right; i++) {
          res.add(arr[i]);
      }
      
      return res;
  }
}