class Solution {
  public String intToRoman(int num) {
      int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
      String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
      String ans = "";

      for (int i = 0; i < symbol.length; i++) {
          while (num >= value[i]) {
              ans += symbol[i];
              num -= value[i];
          }
      }

      return ans;
  }
}