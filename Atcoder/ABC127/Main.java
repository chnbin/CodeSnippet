
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
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int cost = b;
    
    if (a <= 5) {
      cost = 0;
    } else if (a >= 6 && a <=12) {
      cost = b / 2 ;
    }
    System.out.println(cost);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int r = sc.nextInt();
    int d = sc.nextInt();
    int total = sc.nextInt();
    
    for (int i = 0; i < 10; i++) {
      total = (r * total - d);
      System.out.println(total);
    }
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int m = sc.nextInt();
    int maxLeft = Integer.MIN_VALUE;
    int minRight = Integer.MAX_VALUE;
    
    for (int i = 0; i < m; i++) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      maxLeft = Math.max(maxLeft, l);
      minRight = Math.min(minRight, r);
    }
    
    if (minRight - maxLeft + 1 >= 0) {
      System.out.println(minRight - maxLeft + 1);
    } else {
      System.out.println("0");
    
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
