class Solution {
  private static final char[] GCTA = {'G', 'C', 'T', 'A'};
  
  /*
      採用基本BFS做，這很像是Word Ladder
      以AACCGGTT為例：
      _ACCGGTT, A_CCGGTT, AA_CGGTT, AAC_GGTT, AACC_GTT, AACCG_TT, AACCGG_T, AACCGGT_
      把_換成G, C, A, T然後檢查是否在字典裡面且沒有拜訪過，就可以進Queue
  */
  public int minMutation(String start, String end, String[] bank) {
      Queue<String> q = new LinkedList<>();
      Map<String, Integer> map = new HashMap<>();
      Set<String> set = new HashSet<>();
      int res = 0;
      q.offer(start);
      set.add(start);
      
      for (String g: bank) { map.put(g, 1); }
      
      while (!q.isEmpty()) {
          int size = q.size();
          
          for (int i = 0; i < size; i++) {
              String genetic = q.poll();
              
              if (genetic.equals(end)) { return res; }
              
              set.add(genetic);
              
              for (int j = 0; j < genetic.length(); j++) {
                  String leftPart = genetic.substring(0, j);
                  String rightPart = genetic.substring(j + 1);
                  
                  for (char c: GCTA) {
                      String mutation = leftPart + c + rightPart;
                      if (map.containsKey(mutation) && !set.contains(mutation)) {
                          if (genetic.equals(end)) { return res; }
                          q.offer(mutation);
                      }
                  }
              }
          }
          res++;
      }
      
      return -1;
  }
}