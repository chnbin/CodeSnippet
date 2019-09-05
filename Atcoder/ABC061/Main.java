
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static final long MOD = (long)Math.pow(10, 9) + 7;

  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
  }
  
  private static void solveA() {
    FastReader sc = new FastReader();
    String s = sc.next();
    int res = 700;
    for (char c: s.toCharArray()) {
      if (c =='o') { res += 100; }
    }
    System.out.println(res);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int x = sc.nextInt();
    int min = Integer.MAX_VALUE;
    int res = 0;
    
    for (int i = 0; i < n; i++) {
      int material = sc.nextInt();
      x -= material;
      min = Math.min(material, min);
      res++;
    }
    res += (x / min);
    System.out.println(res);
  }


  private static void solveC() {
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();
    long res = 0;
    int abh = 2 * c; // a + b
    
    // buy a + b
    int buyab = Math.min(x, y);
    res += buyab * Math.min(a+b, abh);
    
    x -= buyab;
    y -= buyab;
    
    // buy a
    if (x > 0) { res += (x * Math.min(a, abh)); }
    
    // buy b
    if (y > 0) { res += (y * Math.min(b, abh)); }
    
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
