
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
    int n = sc.nextInt();
    int k = sc.nextInt();
    String s = sc.next();
    
    for (int i = 0; i < n; i++) {
      if ((i + 1) == k) {
        s = s.substring(0, i) + Character.toLowerCase(s.charAt(i)) + s.substring(i+1);
      }
    }
    System.out.println(s);
  }

  private static void solveB() {
    String s = sc.next();
    
    boolean isYYMM = isYYMM(s);
    boolean isMMYY = isMMYY(s);
    
    if (isYYMM && isMMYY) {
      System.out.println("AMBIGUOUS");
    } else if (isYYMM) {
      System.out.println("YYMM");
    } else if (isMMYY) {
      System.out.println("MMYY");
    } else {
      System.out.println("NA");
    }
  }

  private static boolean isYYMM(String date) {
    int year = (date.charAt(0) - '0') * 10 + (date.charAt(1) - '0');
    int month = (date.charAt(2) - '0') * 10 + (date.charAt(3) - '0');
    
    return ((0 <= year) && (year <= 99) && (1 <= month) && (month <=12));
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    double dicePossibility = (1.0 / n);
    int k = sc.nextInt();
    double res = 0.0;
    
    for (int i = 1; i <= n; i++) {
      // i是骰子的點數 iはサイコロの出目です
      int score = i;
      int pow = 0;
      double coinPossibility = 1.0;
      if (i < k) {
          while (score < k) {
            score *= 2;
            pow += 1;
          }
          // System.out.println(pow);
          coinPossibility = Math.pow(0.5, pow * 1.0);
      }
      res += dicePossibility * coinPossibility;
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
