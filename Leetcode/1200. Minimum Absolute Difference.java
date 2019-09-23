import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
      Map<Integer, List<List<Integer>>> map = new HashMap<>();
      int minDist = Integer.MAX_VALUE;
      
      Arrays.sort(arr);
      
      for (int i = 1; i < arr.length; i++) {
          int dist = Math.abs(arr[i] - arr[i - 1]);
          minDist = Math.min(minDist, dist);
          if (!map.containsKey(dist)) {
              map.put(dist, new ArrayList<>());
          }
          List<Integer> idx = new ArrayList<>();
          idx.add(arr[i - 1]);
          idx.add(arr[i]);
          map.get(dist).add(idx);
      }
      return map.get(minDist);
  }
}