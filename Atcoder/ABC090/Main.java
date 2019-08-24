
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
    String a = sc.next();
    String b = sc.next();
    String c = sc.next();

    System.out.println("" + a.charAt(0) + b.charAt(1) + c.charAt(2));
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int res = 0;
    
    for (int i = a; i <= b; i++) {
      if (isPalindromic(i)) {
        res++;
      }
    }
    System.out.println(res);
  }

  private static boolean isPalindromic(int n) {
    int num = n;
    int total = 0;
    while (num != 0) {
      total *= 10;
      total += (num % 10);
      num /= 10;
    }
    return n == total;
  }


  private static void solveC() {
    FastReader sc = new FastReader();
    long n = sc.nextLong();
    long m = sc.nextLong();
    n = (n >= 2) ? n - 2 : 1;
    m = (m >= 2) ? m - 2 : 1;
    
    System.out.println(m*n);
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
