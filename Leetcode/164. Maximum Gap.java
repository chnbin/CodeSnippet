import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public int maximumGap(int[] nums) {
      if (nums.length < 2) { return 0; }
      int res = Integer.MIN_VALUE;
      int base = 1;
      int maxValue = maxOfArray(nums);
      int[] sortedNums = copyArray(nums);
      
      while (maxValue >= base) {
          List<List<Integer>> radixArray = new ArrayList<List<Integer>>();
          for (int i = 0; i < 10; i++) {
              radixArray.add(new ArrayList<Integer>());
          }
          for (int num: sortedNums) {
              int radix = (num / base) % 10;
              radixArray.get(radix).add(num);
          }
          
          int pos = 0;
          
          for (int i = 0; i < radixArray.size(); i++) {
              for (int j = 0; j < radixArray.get(i).size(); j++) {
                  sortedNums[pos++] = radixArray.get(i).get(j);
              }
          }
          
          base *= 10;
      }
      System.out.println(Arrays.toString(sortedNums));
      for (int i = 1; i < sortedNums.length; i++) {
          res = Math.max(res, sortedNums[i] - sortedNums[i-1]);
      }
      return res;
  }
  
  private int maxOfArray(int[] arr) {
      int res = 0;
      for (int num: arr) {
          res = Math.max(res, num);
      }
      return res;
  }
  
  private int[] copyArray(int[] arr) {
      int[] res = new int[arr.length];
      for (int i = 0; i < arr.length; i++) {
          res[i] = arr[i];
      }
      return res;
  }
}