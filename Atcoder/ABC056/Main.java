
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  final static int MOD = 10007;

  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
  }
  

  private static void solveA() {
    Scanner sc = new Scanner(System.in);
    char a = sc.next().charAt(0);
    char b = sc.next().charAt(0);
  
    if ((a == 'H' && b == 'H') || (a == 'D' && b == 'D')) {
      System.out.println("H");
    } else {
      System.out.println("D");
    }
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int w = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    
    int res = 0;
    if (Math.abs(a - b) < w) {
      res = 0;
    } else {
      res = Math.abs(a - b) - w;
    }
    
    System.out.println(res);
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    
    for (int x = 1; x <= n; x++) {
      int t = ((1 + x) * x) / 2;
      if (t >= n) {
        System.out.println(x);
        System.exit(0);
      }
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
