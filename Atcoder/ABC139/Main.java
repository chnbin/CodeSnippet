
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  final static int MOD = 10007;

  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
    solveD();
  }
  

  private static void solveA() {
    FastReader sc = new FastReader();
    String s = sc.next();
    String t = sc.next();
    int res = 0;
    
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t.charAt(i)) {
        res++;
      }
    }
    
    System.out.println(res);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int extend = a - 1;
    int total = 1;
    int res = 0;
    
    while (total < b) {
      total += extend;
      res++;
    }
    System.out.println(res);
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int[] masu = new int[n];
    for (int i = 0; i < n; i++) {
      masu[i] = sc.nextInt();
    }
    int[] dp = new int[n];
    
    for (int i = 1; i < n; i++) {
      if (masu[i] <= masu[i-1]) {
        dp[i] = dp[i-1] + 1;
      }
    }
    
    int res = 0;
    
    
    for (int h: dp) {
      res = Math.max(res, h);
    }
    
    System.out.println(res);
  }

  private static void solveD() {
     FastReader sc = new FastReader();
    long n = sc.nextLong();
    long m = n - 1;
    long res = ((1 + m) * m)/2;
    System.out.println(res);
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
