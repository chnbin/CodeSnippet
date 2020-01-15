class Solution {
  public boolean isLongPressedName(String name, String typed) {
      char[] nameChar = name.toCharArray();
      char[] typedChar = typed.toCharArray();
      int pos = 0;
      
      for (int i = 0; i < typedChar.length; i++) {
          if (pos < name.length() && nameChar[pos] == typedChar[i]) {
              pos++;
          }
      }
      return pos == name.length();
  }
}