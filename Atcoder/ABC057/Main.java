
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
    System.out.println((a + b) % 24);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int[][] studentPos = new int[n][2];
    int[] useCheckPoint = new int[n];
    int m = sc.nextInt();
    int[][] checkPointPos = new int[m][2];
    
    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      studentPos[i][0] = x;
      studentPos[i][1] = y;
    }
    
    for (int i = 0; i < m; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      checkPointPos[i][0] = x;
      checkPointPos[i][1] = y;
    }
    
    for (int i = 0; i < n; i++) {
      int dist = Integer.MAX_VALUE;
      int pos = 0;
      for (int j = 0; j < m; j++) {
        int currDist = Math.abs(studentPos[i][0] - checkPointPos[j][0]) + Math.abs(studentPos[i][1] - checkPointPos[j][1]);
        if (currDist < dist) {
          dist = currDist;
          pos = j + 1;
        }
      }
      useCheckPoint[i] = pos;
    }
    for (int i = 0; i < useCheckPoint.length; i++) {
      System.out.println(useCheckPoint[i]);
    }
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    long n = sc.nextLong();
    int res = Integer.MAX_VALUE;
    
    for (long i = 1; i <= (long)Math.sqrt(n*1.0); i++) {
      if (n % i == 0) {
        res = Math.min(res, F(i, n/i));
      } 
    }
    
    System.out.println(res);
  }

  private static int F(long a, long b) {
    return Math.max(findDigit(a), findDigit(b));
  }
  
  private static int findDigit(long num) {
    int n = 0;
    while (num != 0) {
      n++;
      num /= 10;
    }
    return n;
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
