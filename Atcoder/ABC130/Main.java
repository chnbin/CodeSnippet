
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
    int x = sc.nextInt();
    int a = sc.nextInt();
    
    if (x < a) {
      System.out.println(0);
    } else {
      System.out.println(10);
    }
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int x = sc.nextInt();
    int res = 0;
    int[] d = new int[n+1];
 
    for (int i = 0; i < n; i++) {
      int ls = sc.nextInt();
      d[i+1] = ls + d[i];
      if (d[i+1] <= x) {
        res++;
      }
    }
    // System.out.println(Arrays.toString(d));
    System.out.println(res+1);
  }


  private static void solveC() {
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();
    
    double minMax = ((double)a * (double)b / 2.0);
    int res = 0;
    if ((x * 2) == a && (y * 2) == b) {
      res = 1;
    }
    System.out.println(minMax + " " + res);
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
