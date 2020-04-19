class Solution {
  public int findBestValue(int[] arr, int target) {
      int left = 0;
      int sum = sumOfArr(arr);
      int right = maxOfArr(arr); //(sum / arr.length) + 1;
      int prevValue = right;
      int diff = Integer.MAX_VALUE;
      
      while (left <= right) {
          int mid = (left + right) / 2;
          int curr = helper(arr, mid);
          int currentDiff = Math.abs(target - curr);
          
          if(currentDiff < diff){
              diff = currentDiff;
              prevValue = mid;
          }
          else if(currentDiff == diff){
              prevValue = Math.min(prevValue, mid);
          }
          
          if (curr <= target) {
              left = mid + 1;
          } else  {
              right = mid - 1;
          }
          
      }
      
      return prevValue;
  }
  
  private int sumOfArr(int[] arr) {
      int sum = 0;
      
      for (int num: arr) { sum += num; }
      
      return sum;
  }
  
  private int helper(int[] arr, int value) {
      int sum = 0;
      
      for (int num: arr) {
          if (num >= value) {
              sum += value;
          } else {
              sum += num;
          }
      }
      
      return sum;
  }
  
  private int minOfArr(int[] arr) {
      int min = 0;
      
      for (int num: arr) { min = Math.min(min, num); }
      
      return min;
  }
  
  private int maxOfArr(int[] arr) {
      int max = 0;
      
      for (int num: arr) { max = Math.max(max, num); }
      
      return max;
  }
}
