class Solution {
  public int sumOfDigits(int[] A) {
      int minValue = Integer.MAX_VALUE;
      
      for (int value: A) {
          minValue = Math.min(minValue, value);
      }
      
      int sum = 0;
      
      while (minValue > 0) {
          sum += (minValue % 10);
          minValue /= 10;
      }
      
      return (sum % 2 == 0) ? 1 : 0;
  }
}