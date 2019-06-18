class Solution {
  public String complexNumberMultiply(String a, String b) {
      int r1 = findRealPart(a);
      int c1 = findComplexPart(a);
      int r2 = findRealPart(b);
      int c2 = findComplexPart(b);
      return (r1*r2 - c1*c2) + "+" + (r1*c2 + r2*c1) + "i";
  }
  
  private int findRealPart(String s) {
      String[] realAndComplex = s.split("\\+");
      return Integer.parseInt(realAndComplex[0]);
  }
  
  private int findComplexPart(String s) {
      String[] realAndComplex= s.split("\\+");
      return Integer.parseInt(realAndComplex[1].replace("i", ""));
  }
}