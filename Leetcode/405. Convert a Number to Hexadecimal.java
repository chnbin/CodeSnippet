class Solution {
  public String toHex(int num) {
      if (num == 0) { return "0"; }
      String res = "";
      char[] charTable = {'0', '1', '2', '3', '4', '5', '6', '7', '8', 
                          '9', 'a', 'b', 'c', 'd', 'e', 'f'};
      
      while (num != 0) {
          res = charTable[num & 0b1111] + res;
          num >>>= 4;
      }
      return res;
  }
}