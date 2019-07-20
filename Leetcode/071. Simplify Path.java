import java.util.LinkedList;

class Solution {
  public String simplifyPath(String path) {
      LinkedList<String> stack = new LinkedList<>();
      int len = path.length();
      int pos = 0;
      StringBuilder curr = new StringBuilder();
      
      while (pos < len) {
          char c = path.charAt(pos);
          
          if (c == '/' || pos == len - 1) {
              // For cases like: /../../../a/b/b/vbnm
              // Not ending with /
              if (pos == len - 1 && c != '/') {
                  curr.append(c);
              }
              String tmp = curr.toString();
              if (tmp.equals("..")) {
                  // Moves the directory up a level
                  if (stack.size() > 0) {
                      stack.pop();
                  }
              } else if (tmp.equals(".")) {
                  // Do nothing
              } else {
                  if (!tmp.equals("")) {
                      stack.push(tmp);
                  }
              }
              
              curr = new StringBuilder();
          } else {
              curr.append(c);
          }
          
          pos++;
      }
      
      if (stack.size() == 0) { return "/"; }
      
      String res = "";
      
      while (stack.size() > 0) {
          res = "/" + stack.pop() + res;
      }
       
      return res;
  }
}