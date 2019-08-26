
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
    int x = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    
    if (b - a <= 0) {
      System.out.println("delicious");
    } else {
      if (b - a > x) {
        System.out.println("dangerous");
      } else {
        System.out.println("safe");
      }
    }
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int nextPos = 1;
    boolean[] visited = new boolean[n+1];
    int step = 0;
    int[] buttons = new int[n];
    
    for (int i = 0; i < n; i++) {
      buttons[i] = sc.nextInt();
    }
    while (!visited[nextPos]) {
      step++;
      visited[nextPos] = true;
      nextPos = buttons[nextPos-1];
      if (nextPos == 2) {
        System.out.println(step++);
        System.exit(0);
      }
    }
    System.out.println(-1);
  }


  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int m = sc.nextInt();
    
    if (Math.abs(m - n) > 1) {
      System.out.println(0);
      System.exit(0);
    }
    int max = Math.max(m, n);
    
    long[] dp = new long[max + 1];
    dp[1] = 1;
    
    for (int i = 2; i <= max; i++) {
      dp[i] = (dp[i - 1] % MOD) * (i % MOD);
      dp[i] %= MOD;
    }
    int times = 1;
    // //同数なら猿犬猿犬と犬猿犬猿が可能なので2倍。
    if (m == n) { times = 2; }
    System.out.println(((dp[m]*dp[n]*times) % MOD));
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
