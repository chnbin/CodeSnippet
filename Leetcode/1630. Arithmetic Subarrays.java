class Solution {
  public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
      List<Boolean> res = new ArrayList<>();
      
      for (int i = 0; i < l.length; i++) {
          List<Integer> query = new ArrayList<>();
          
          for (int j = l[i]; j <= r[i]; j++) {
              query.add(nums[j]);
              // System.out.println(nums[j]);
          }
          Collections.sort(query);
          res.add(isArithmetic(query));
      }
      
      return res;
  }
  
  
  private boolean isArithmetic(List<Integer> arr) {
      if (arr.size() < 2) {
          return false;
      }
      
      if (arr.size() == 2) {
          return true;
      }
      
      int diff = arr.get(1) - arr.get(0);
      for (int i = 2; i < arr.size(); i++) {
          if (arr.get(i) - arr.get(i - 1) != diff) {
              return false;
          }
      }
      
      return true;
  }
}
