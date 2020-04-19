class Solution {
  public int[] arrayRankTransform(int[] arr) {
      if (arr == null || arr.length == 0) { return arr; }
      
      int[] res = new int[arr.length];
      Map<Integer, Integer> map = new HashMap<>();
      int[] newArr = copyArrays(arr);
      Arrays.sort(newArr);
      
      int pos = 1;
      
      for (int i = 0; i < newArr.length; i++) {
          if (!map.containsKey(newArr[i])){
              map.put(newArr[i], pos);
              pos++;   
          }
      }
      
      for (int i = 0; i < arr.length; i++) {
          res[i] = map.get(arr[i]);
      }
      
      return res;            
  }
  
  private int[] copyArrays(int[] arr) {
      int[] res = new int[arr.length];
      
      for (int i = 0; i < arr.length; i++) {
          res[i] = arr[i];
      }
      
      return res;
  }
}
