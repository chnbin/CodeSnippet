
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static final long MOD = (long)Math.pow(10, 9) + 7;

  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
  }
  
  private static void solveA() {
    FastReader sc = new FastReader();
    long x = sc.nextLong();
    String res = "ARC";
    if (x < 1200) {
      res = "ABC";
    }
    System.out.println(res);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    String s = sc.next();
    int idx1 = -1;
    int idx2 = -1;
    
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'A') {
        idx1 = i;
        break;
      }
    }
    
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (c == 'Z') {
        idx2 = i;
        break;
      }
    }
    System.out.println(idx2 - idx1 + 1);
  }


  private static void solveC() {
    FastReader sc = new FastReader();
    long x = sc.nextLong();
    // 5, 6重複翻
    long times = x / 11L;
    
    long remainder = x % 11L;
    
    if (remainder == 0) {
      remainder = 0;
    } else {
      if (remainder > 6) {
        remainder = 2;
      } else {
        remainder = 1;
      }
    }
    System.out.println(times * 2L + remainder);
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
