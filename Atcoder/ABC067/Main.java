
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
    int a = sc.nextInt();
    int b = sc.nextInt();
    
    if (a % 3 == 0 || b % 3 == 0 || (a + b) % 3 == 0) {
      System.out.println("Possible");
    } else {
      System.out.println("Impossible");
    }
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] sticks = new int[n];
    for (int i = 0; i < sticks.length; i++) {
      sticks[i] = sc.nextInt();
    }
    Arrays.sort(sticks);
    int res = 0;
    int pos = sticks.length - 1;
    
    while (k > 0) {
      res += sticks[pos];
        k--;
        pos--;
    }
    System.out.println(res);
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int[] nums = new int[n];
    long[] prefix = new long[n];
    long[] postfix = new long[n];

    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    prefix[0] = nums[0];
    for (int i = 1; i < n; i++) {
      prefix[i] = nums[i] + prefix[i - 1];
    }
    
    for (int i = n - 2; i >=0; i--) {
      postfix[i] = nums[i + 1] + postfix[i + 1];
    }
    long res = Integer.MAX_VALUE;
    for (int i = 0; i < n - 1; i++) {
      res = Math.min(res, Math.abs(prefix[i] - postfix[i]));
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
