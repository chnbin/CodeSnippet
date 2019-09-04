
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
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();
    
    int res = Math.max(a*b, d*c);
    System.out.println(res);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    String s = sc.next();
    int res = 0;
    int sum = 0;
    for (int i = 0 ; i < n; i++) {
      char c = s.charAt(i);
      if (c == 'I') {
        sum++;
      } else {
        sum--;
      }
      res = Math.max(res, sum);
    }
    System.out.println(res);
  }


  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    
    int[] primes = new int[1001];
    primes[1] = 1;
    int pos = 1;
    
    for (int i = 2; i <= n; i++) {
      int num = i;
      int k = 2;
      while (num >= k) {
        if (num == k) {
          primes[k]++;
          break;
        }
        if (num % k == 0) {
          primes[k]++;
          num /= k;
        } else {
          k++;
        }
      }
    }
    long res = 1L;
    
    for (int i = 1; i <= 1000; i++) {
      if (primes[i] >= 1) {
        res = (res % MOD) * ((primes[i]+1) % MOD);
      }
    }

    System.out.println(res/2);
  }

  private static void solveD() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    long[] street = new long[n];

    long res = 0l;
    for (int i = 0; i < n; i++) {
      street[i] = sc.nextLong();
    }
    
    for (int i = 1; i < n; i++) {
      res += (Math.min((street[i] - street[i-1]) * a, b));
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
