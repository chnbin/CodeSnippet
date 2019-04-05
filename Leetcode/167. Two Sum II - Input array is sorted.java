class Solution {
  public int[] twoSum(int[] numbers, int target) {
      int left = 0;
      int right = numbers.length - 1;
      int total = 0;
      int[] indice = new int[2];

      while (left < right) {
          total = numbers[left] + numbers[right];
          
          if (total == target) {
              indice[0] = left + 1;
              indice[1] = right + 1;
              break;
          } else if (total > target) {
              right -= 1;
          } else {
              left += 1;
          }
      }
      return indice;
  }
}