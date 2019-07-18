import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
      if (K == 0) {
          List<Integer> res = new ArrayList<>();
          res.add(target.val);
          return res;
      }
      Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
      Set<Integer> visited = new HashSet<>();
      bulidGraphFromTree(root, graph, -1);
      // System.out.println(graph.toString());
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(target.val);
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          List<Integer> res = new ArrayList<>();
          
          for (int i = 0; i < size; i++) {
              int node = queue.poll();
              visited.add(node);
              for (int v: graph.get(node)) {
                  if (!visited.contains(v)) {
                      queue.offer(v);
                      res.add(v);
                  }
              }
          }
          K--;
          if (K == 0) { return res; }
      }
      
      
      return new ArrayList<Integer>();
  }
  
  private void bulidGraphFromTree(TreeNode node, Map<Integer, ArrayList<Integer>> graph, int parent) {
      if (node == null) { return; }
      int nodeValue = node.val;
      if (!graph.containsKey(nodeValue)) {
          graph.put(nodeValue, new ArrayList<Integer>());
      }
      
      if (parent != -1) {
          graph.get(parent).add(nodeValue);
          graph.get(nodeValue).add(parent);
      }
      bulidGraphFromTree(node.left, graph, nodeValue);
      bulidGraphFromTree(node.right, graph, nodeValue);
  }
}