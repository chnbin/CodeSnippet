
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
    int n = sc.nextInt();
    System.out.println(n * 800 - (n / 15)*200);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    
    long res = 1l;
    
    for (int i = 2; i <= n; i++) {
      res = (res*i) % MOD;
    }
    System.out.println(res);
  }


  private static void solveC() {
    FastReader sc = new FastReader();
    long s = sc.nextLong();
    long c = sc.nextLong();
    long res = 0l;
    
    
    if (2*s == c) {
      res += s;
      s = 0;
      c = 0;
    } else if (2*s < c) {
      res += s;
      c -= 2*s;
      s = 0;
    } else if (2*s > c) {
      res += (c / 2);
      s -= (c / 2);
      c -= (c / 2)*2;
    }
    
    
    System.out.println(res + c/4);
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
