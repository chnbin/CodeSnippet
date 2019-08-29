
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  final static int MOD = 10007;

  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
  }
  
  private static void solveA() {
    FastReader sc = new FastReader();
    String s = sc.next();
    System.out.println("ABC" + s);
  }
  
  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int res = 0;
    if (n >= 64 && n <= 100) {
      res = 64;
    } else if (n >= 32 && n <= 63) {
      res = 32;
    } else if (n >= 16 && n <= 31) {
      res = 16;
    } else if (n >= 8 && n <= 15) {
      res = 8;
    } else if (n >= 4 && n <= 7) {
      res = 4;
    } else if (n >= 2 && n <= 3) {
      res = 2;
    } else {
      res = 1;
    }
    System.out.println(res);
  }
  
  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int m = sc.nextInt();
    boolean[] isLand1ToLandx = new boolean[n + 1];
    boolean[] isLandxToLandn = new boolean[n + 1];
    
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      
      if (a == 1) { isLand1ToLandx[b] = true; }
      if (b == n) { isLandxToLandn[a] = true; }
    }
    
    for (int i = 1; i < isLand1ToLandx.length; i++) {
      if (isLand1ToLandx[i]) {
        if (isLandxToLandn[i]) {
          System.out.println("POSSIBLE");
          System.exit(0);
        }
      }
    }
    
    System.out.println("IMPOSSIBLE");
  }

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
