class NumArray {
  int[] prefix;

  public NumArray(int[] nums) {
      prefix = nums;
      
      for (int i = 1; i < prefix.length; i++) {
          prefix[i] += prefix[i-1];
      }
  }
  
  public int sumRange(int i, int j) {
      if (i == 0) {
          return prefix[j];
      } else {
          return prefix[j] - prefix[i-1];
      }
  }
}