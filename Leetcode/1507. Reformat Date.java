class Solution {
  public String reformatDate(String date) {
      String res = "";
      String[] info = date.split(" ");
      String day = getDay(info[0]);
      String month = getMonth(info[1]);
      return info[2] + "-" + month + "-" + day;
  }
  
  private String getDay(String day) {
      String res = "";
      
      for (int i = 0; i < day.length(); i++) {
          char c = day.charAt(i);
          if (c >= '0' && c <= '9') {
              res += c;
          } else {
              break;
          }
      }
      
      if (res.length() == 1) {
          res = "0" + res;
      }
      
      return res;
  }
  
  private String getMonth(String month) {
      Map<String, String> map = new HashMap<>();
      String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      
      for (int i = 0; i < 12; i++) {
          String m = "";
          if (i < 9) { m += "0"; }
          map.put(months[i], m += (i+1));
      }
      return map.get(month);
  }
}
