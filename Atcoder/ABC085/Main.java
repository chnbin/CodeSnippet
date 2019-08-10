
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  // AtCoder Beginner Contest 085
  // https://atcoder.jp/contests/abc085/tasks
  public static void main(String[] args) {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int[] mochis = new int[n];

    for (int i = 0; i < n; i++) {
      mochis[i] = sc.nextInt();
    }
    Arrays.sort(mochis);
    int res = 1;
    
    for (int i = n - 2; i >= 0; i--) {
      if (mochis[i] < mochis[i+1]) {
        res++;
      }
    }
    System.out.println(res);
  }

  public static void sovleA() {
    FastReader sc = new FastReader();
    String s = sc.next();
    s = s.substring(0, 3) + "8" + s.substring(4);
    System.out.println(s);
  }

  public static void sovleB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int[] mochis = new int[n];

    for (int i = 0; i < n; i++) {
      mochis[i] = sc.nextInt();
    }
    Arrays.sort(mochis);
    int res = 1;

    for (int i = n - 2; i >= 0; i--) {
      if (mochis[i] < mochis[i+1]) {
        res++;
      }
    }
    System.out.println(res);
  }

  public static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int yen = sc.nextInt();
    
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n - i; j++) {
        for (int k = 0; k <= n - i - j; k++) {
          if ((10000 * i + 5000 * j + 1000 * k) == yen && (i + j + k) == n) {
            System.out.println("" + i + " " + j + " " + k);
            System.exit(0);
          }
        }
      }
    }
    
    System.out.println("-1 -1 -1");
  }

  public static void solveD() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int h = sc.nextInt();
    int swipeMax = 0;
    int[] throwW = new int[n];

    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      swipeMax = Math.max(swipeMax, a);
      throwW[i] = b;
    }

    Arrays.sort(throwW);

    int cnt = 0;
    int throwWPos = n - 1;
    
    while (h > 0) {
      int damage = swipeMax;
      
      if (throwWPos >= 0 && throwW[throwWPos] > swipeMax) {
        damage = throwW[throwWPos];
        throwWPos--;
      }
      h -= damage;
      cnt++;
    }
    System.out.println(cnt);

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
