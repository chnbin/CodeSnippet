import java.util.HashSet;
import java.util.Set;

class Solution {
  public int numUniqueEmails(String[] emails) {
      Set<String> set = new HashSet<>();
      for (String email: emails) {
          String[] content = email.split("@");
          String localName = content[0];
          String domainName = content[1];
          set.add(localName.replace(".", "").split("\\+")[0] + "@" + domainName);
      }
      return set.size();
  }
}