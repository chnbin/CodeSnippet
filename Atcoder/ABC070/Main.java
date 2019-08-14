
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // AtCoder Beginner Contest 070
  // https://atcoder.jp/contests/abc070/tasks
  public static void main(String[] args) {
	solveA();
	solveB();
	solveC();
  }
  
  private static void solveA() {
    FastReader sc = new FastReader();
	int n = sc.nextInt();
	
	if ((n%10) == (n/100)) {
		System.out.println("Yes");
	} else {
		System.out.println("No");
	}
  }
  
  private static void solveB() {
    FastReader sc = new FastReader();
	int a = sc.nextInt();
	int b = sc.nextInt();
	int c = sc.nextInt();
	int d = sc.nextInt();
	System.out.println(Math.max(Math.min(b, d) - Math.max(a, c), 0));
  }
  
  private static void solveC() {
	  FastReader sc = new FastReader();
		int n = sc.nextInt();
		long[] clocks = new long[n];
		long res = 1;

		for (int i = 0; i < n; i++) {
		  clocks[i] = sc.nextLong();
		}
			
		if (n == 1) {
		  System.out.println(clocks[0]);
		  System.exit(0);
		}
		res = clocks[0]/gcd(clocks[0], clocks[1])*clocks[1];
		for (int i = 2; i < n; i++) {
			res = res/gcd(res, clocks[i])*clocks[i];
		}
		
		System.out.println(res);
  }
  
  private static long gcd(long m, long n) {
	  if (m < n) { return gcd(n, m); }
	  if (n == 0) { return m; }
	  return gcd(n, m % n);
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
