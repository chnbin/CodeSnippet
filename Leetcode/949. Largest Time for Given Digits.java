import java.util.Arrays;

class Solution {
  public String largestTimeFromDigits(int[] A) {
      int[] nums = new int[10];
      
      for (int num: A) {
          nums[num]++;
      }
      // System.out.println(Arrays.toString(nums));
      int[] tmp = new int[10];
      for (int i = 23; i >=0; i--) {
          tmp[i/10]++;
          tmp[i%10]++;
          for (int j = 59; j >= 0; j--) {
              tmp[j/10]++;
              tmp[j%10]++;
              if (Arrays.equals(nums, tmp)) {
                  return "" + (int)(i/10) + (int)(i%10) + ":"+ (int)(j/10) + (int)(j%10);
              }
              // System.out.println(Arrays.toString(tmp));
              tmp[j/10]--;
              tmp[j%10]--;
          }
          tmp[i/10]--;
          tmp[i%10]--;
      }
      
      return "";
  }
}