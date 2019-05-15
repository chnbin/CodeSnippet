class Solution {
  public int[] sortArray(int[] nums) {
      if (nums == null || nums.length == 0) { return nums; }
      quickSort(nums, 0, nums.length - 1);
      return nums;
  }
   
  private void quickSort(int[] arr, int start, int end) {
      if (start >= end) { return; }
      int pivotIndex = partition(arr, start, end);
      quickSort(arr, start, pivotIndex - 1);
      quickSort(arr, pivotIndex + 1, end);
      
  }
  
  private int partition(int[] arr, int start, int end) {
      int pos = start-1;
      int pivot = arr[end];
      
      for (int i = start; i < end; i++) {
          if (pivot > arr[i]) {
              pos++;
              swap(arr, pos, i);
          }
      }
      pos++;
      swap(arr, pos, end);
      
      return pos;
  }
  
  private void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }
}