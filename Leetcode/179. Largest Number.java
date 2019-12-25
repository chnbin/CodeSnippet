class Solution {
  public String largestNumber(int[] nums) {
      // 其實就是自訂排序，排序的原則就是把兩個數字都變成字串
      // 例如s1 = "3", s2 = "39"，s1+s2 = 339; s2+s1=392
      // 因此339應該在前面
      String[] strs = new String[nums.length];
      
      for (int i = 0; i < nums.length; i++) {
          strs[i] = String.valueOf(nums[i]);
      }
      
      Arrays.sort(strs, (s1, s2) -> {
          return (s2 + s1).compareTo(s1 + s2);
      });
      
      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < strs.length; i++) {
          sb.append("" + strs[i]);
      }
      
      String res = sb.toString();
      
      return (res.charAt(0) == '0') ? "0" : res;
  }
}