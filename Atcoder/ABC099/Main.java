
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  private static final int BASE = -2;
  private static final int CAKECOST = 4;
  private static final int DONUTCOST = 7;

  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
  }
  

  private static void solveA() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    if (n >= 1 && n <= 999) {
      System.out.println("ABC");
    } else {
      System.out.println("ABD");
    }
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int[] height = new int[1000];
    
    for (int i = 1; i <= 999; i++) {
      height[i] = ((i + 1) * i) / 2;
    }
    
    for (int i = 1; i <= 998; i++) {
      if (a <= height[i] && b <= height[i+1]) {
        if (height[i] - a == height[i+1] - b) {
          System.out.println(height[i]-a);
          System.exit(0);
        }
      }
    }
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int[] dp = new int[n+1];
    
    for (int i = 1; i <= n; i++) {
      // 先換1元
      dp[i] = dp[i-1] + 1;
      
      // 再換6^n元
      int power6 = 6;
      while (i >= power6) {
        dp[i] = Math.min(dp[i], 1 + dp[i - power6]);
        power6 *= 6;
      }
      
      // 再換9^n元
      int power9 = 9;
      while (i >= power9) {
        dp[i] = Math.min(dp[i], 1 + dp[i - power9]);
        power9 *= 9;
      }
    }
    
    System.out.println(dp[n]);
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
