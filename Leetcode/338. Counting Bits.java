class Solution {
  public int[] countBits(int num) {
      /*
          00 0000 0000 0
          01 0000 0001 1
          02 0000 0010 1 
          03 0000 0011 2
          04 0000 0100 1
          05 0000 0101 2
          06 0000 0110 2
          07 0000 0111 3
          08 0000 1000 1
          09 0000 1001 2
          10 0000 1010 2
          11 0000 1011 3
          12 0000 1100 2
          13 0000 1101 3
          14 0000 1110 3
          15 0000 1111 4
          16 0001 0000 1
          17 0001 0001 2
          18 0001 0010 2
          19 0001 0011 3
          20 0001 0100 2
          21 0001 0101 3
          22 0001 0110 3
          23 0001 0111 4
          24 0001 1000 2
          25 0001 1001 3
          26 0001 1010 3
          27 0001 1011 4
          28 0001 1100 3
          29 0001 1101 4
          30 0001 1110 4
          31 0001 1111 5
          0
          1 
          1 2 
          1 2 2 3 
          1 2 2 3 2 3 3 4 
          1 2 2 3 2 3 3 4 2 3 3 4 3 4 4
          有點像Grey Code但是這樣是O(n^2)
      */
      int[] res = new int[num + 1];
      int pos = 0;
      boolean isEnd = false;
      List<Integer> bits = new ArrayList<>();
      bits.add(0);
      
      while (!isEnd && num != 0) {
          int size = bits.size();
          for (int i = pos; i < size; i++){
              bits.add(bits.get(i) + 1);
              if (bits.size() == (num + 1)) { isEnd = true;  break;}
          }
          pos = 0;
      }
      
      for (int i = 0; i < bits.size(); i++) {
          res[i] = bits.get(i);
      }
      
      return res;
  }
}