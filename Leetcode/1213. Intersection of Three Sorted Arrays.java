class Solution {
  public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
      List<Integer> res = new ArrayList<>();
      int[] table = new int[2001];
      
      for (int i = 0; i < arr1.length; i++) {
          table[arr1[i]]++;
      }
      
      for (int i = 0; i < arr2.length; i++) {
          table[arr2[i]]++;
      }
      
      for (int i = 0; i < arr3.length; i++) {
          table[arr3[i]]++;
          if (table[arr3[i]] == 3) {
              res.add(arr3[i]);
          }
      }
      return res;
  }
}