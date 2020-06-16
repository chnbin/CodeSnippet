class Solution {
  public String validIPAddress(String IP) {
      /*
          合法的IPv4
          用.可以分割為四組。
          每組不為空。
          每組的長度<=3。
          每組的範圍在0到255
          除非本身為0，否則沒有前導0
          
          合法的IPv6
          用:可以分成8組
          每組不為空
          每組長度<=4
          每組為一個16進位數字範圍是:0-9,a-f,A-F
      */
      if (IP == null || IP.length() == 0) { return "Neither"; }
      if (isIPV4(IP)) return "IPv4";
      if (isIPv6(IP)) return "IPv6";
      return "Neither";
  }
  
  private boolean isIPV4(String ip) {
      String[] ips = ip.split("\\.");
      if (ips.length != 4) { return false; }
      if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') { return false; }
      
      for (int i = 0; i < ips.length; i++) {
          if (!isIPV4Group(ips[i])) { return false; }
      }
      return true;
  }
  
  private boolean isIPV4Group(String ip) {
      if (ip == null || ip.length() == 0 || ip.length() > 3) { return false; }
      for (int i = 0; i < ip.length(); i++) {
          if (!(ip.charAt(i) <= '9' && ip.charAt(i) >= '0')) { return false; }
      }
      int x = Integer.valueOf(ip);
      if (x < 0 || x > 255 || (ip.charAt(0) == '0' && ip.length() > 1)) { return false; }
      return true;
  }
  
  public boolean isIPv6(String IP){
      String[] ips = IP.split(":");
      if (ips.length != 8) return false;
      if (IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':') return false;
      for (int i = 0 ; i < ips.length ; i ++){

          if (!isIPv6Group(ips[i])) return false;
      }
      return true;
  }

  private boolean isIPv6Group(String IPG){
      if (IPG == null || IPG.length() == 0 || IPG.length() > 4) return false;
      for (int i = 0 ; i < IPG.length(); i++) 
          if (!('0' <= IPG.charAt(i) && IPG.charAt(i) <= '9' || 'a' <= IPG.charAt(i) && IPG.charAt(i) <= 'f' || 'A' <= IPG.charAt(i) && IPG.charAt(i) <='F'))
              return false;
      return true;
  }
}
