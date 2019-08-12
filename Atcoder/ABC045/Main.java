
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
	  FastReader sc = new FastReader();
	  String a = sc.next();
	  String b = sc.next();
	  String c = sc.next();
	  int posA = 0;
	  int posB = -1;
	  int posC = -1;
	  char turn = 'a';
	  
  }
  
  private static void solveA() {
	  FastReader sc = new FastReader();
	  int a = sc.nextInt();
	  int b = sc.nextInt();
	  int h = sc.nextInt();
	  
	  System.out.println((a + b) * (h / 2));
  }
  
  private static void solveB() {
	  FastReader sc = new FastReader();
	  String a = sc.next();
	  String b = sc.next();
	  String c = sc.next();
	  int posA = 0;
	  int posB = -1;
	  int posC = -1;
	  char turn = 'a';
	  while (posA < a.length() && posB < b.length() && posC < c.length()) {
		  switch (turn) {
		  	  case 'a':
		  		  posA++;
		  		  if (posA == a.length()) {
		  			  System.out.println("A");
		  			  System.exit(0);
		  		  }
		  		  turn = a.charAt(posA);
		  		  break;
		  	  case 'b':
		  		  posB++;
		  		  if (posB == b.length()) {
		  			  System.out.println("B");
		  			  System.exit(0);
		  		  }
		  		  turn = b.charAt(posB);
		  		  break;
		  	  case 'c':
		  		  posC++;
		  		  if (posC == c.length()) {
		  			  System.out.println("C");
		  			  System.exit(0);
		  		  }
		  		  turn = c.charAt(posC);
		  		  break;
		  }
	  }
  }
  
  private static void solveC() {
	  FastReader sc = new FastReader();
	  String s = sc.next();
	  long[] res = new long[2];
	  helper(s, 1, s.substring(0, 1) , res);
	  System.out.println(res[0]);
  }
  
  private static void helper(String s, int pos, String currTmp, long[] res) {
	  if (pos == s.length()) {
		  // System.out.println(currTmp);
		  res[0] += computeFormula(currTmp);
	  } else {
		  if (pos < s.length()) {
			  helper(s, pos + 1, currTmp + s.charAt(pos), res);
			  helper(s, pos + 1, currTmp + "+" + s.charAt(pos), res);
		  }
	  }
  }

  private static long computeFormula(String s) {
	  long res = 0;
	  long num = 0;
	  for (int i = 0; i < s.length(); i++) {
		  char c = s.charAt(i);
		  
		  if (c == '+') {
			  res += num;
			  num = 0;
		  } else {
			  num *= 10;
			  num += c - '0';
			  if (i == s.length() - 1) {
				  res += num;
				  num = 0;
			  }
		  }
	  }

	  return res;
  }
  
  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }
  
    String next() { 
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException  e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() { 
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
        try{
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
      }
  }
}
