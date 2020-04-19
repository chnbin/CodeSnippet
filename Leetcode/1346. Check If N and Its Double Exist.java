class Solution {
  public boolean checkIfExist(int[] arr) {
      Set<Double> set = new HashSet();
      
      for (int num: arr) {
          double half = num / 2.0;
          double twice = num * 2.0;
          
          if (set.contains(half) || set.contains(twice)) {
              return true;
          }
          set.add(num * 1.0);
      }
      return false;
  }
}
