class Solution {
  public int repeatedStringMatch(String A, String B) {
      int count = 1;
      StringBuilder temp = new StringBuilder(A);
      
      while(temp.length()<B.length()){
        temp.append(A);
        count++;
      }
      
      if(temp.indexOf(B)>=0) return count;
      
      if(temp.append(A).indexOf(B)>=0) return count+1;
      return -1;
      }
}