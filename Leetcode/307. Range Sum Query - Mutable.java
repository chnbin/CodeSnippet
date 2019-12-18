class NumArray {
  int[] nums;
  int[] prefix;
  public NumArray(int[] nums) {
      this.nums = nums;
      prefix = new int[nums.length + 1];
      prefix[0] = 0;
      
      for (int i = 0; i < nums.length; i++) {
          prefix[i + 1] = nums[i] + prefix[i];
      }
  }
  
  public void update(int i, int val) {
      int num = nums[i];
      nums[i] = val;
      
      for (int j = i + 1; j < prefix.length; j++) {
          prefix[j] += (val - num);
      }
  }
  
  public int sumRange(int i, int j) {
      return prefix[j + 1] - prefix[i];
  }
}

/**
* Your NumArray object will be instantiated and called as such:
* NumArray obj = new NumArray(nums);
* obj.update(i,val);
* int param_2 = obj.sumRange(i,j);
*/