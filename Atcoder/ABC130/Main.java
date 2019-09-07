
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
    solveD();
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

  private static void solveD() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    long k = sc.nextLong();
    int[] nums = new int[n];
    
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }

    long res = 0;
    long sum = 0;
    int r = 0;
    
    // Tow pointer
    // l與r都從0開始，一個一個找，只要sum(l, r) >= K
    // 則代表 sum(l, r), sum(l, r+1), sum(l, r+2),...,sum(l, n-1)都是>=k
    // 因此共n - r + 1個。
    // 然後往下一個l繼續找
    // 也可以用Binary search, 變成binary serach + function
    for (int l = 0; l < n; l++) {
      while (sum < k) {
        if (r == n) {
          break;
        } else {
          sum += nums[r];
          r++;
        }
      }
      if (sum >=k) {
        res += (n - r + 1);
        sum -= nums[l];
      }
    }
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
