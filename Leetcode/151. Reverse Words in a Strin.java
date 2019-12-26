class Solution {
  public String reverseWords(String s) {
      String[] strs = s.split(" ");
      List<String> list = new ArrayList<>();
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < strs.length; i++) {
          if (!strs[i].equals("")) {
              list.add(strs[i]);
          }
      }
      
      for (int i = list.size() - 1; i >= 0; i--) {
          sb.append(list.get(i));
          if (i != 0) {sb.append(" "); }
      }
      
      return sb.toString();
  }
}