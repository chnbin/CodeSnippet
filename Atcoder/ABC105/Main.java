
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
  }
  

  private static void solveA() {
    FastReader sc = new FastReader();
    int m = sc.nextInt();
    System.out.println(48 - m);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    String s = sc.next();
    
    if (s.charAt(a) != '-') {
      System.out.println("No");
      System.exit(0);
    }
    
    for (int i = 0; i < s.length(); i++) {
      if (i != a) {
        if (!Character.isDigit(s.charAt(i))) {
          System.out.println("No");
          System.exit(0);
        }
      }
    }
    System.out.println("Yes");
    System.exit(0);
  }

  private static void solveC() {
    /*
     作法與2的補數是相同的，但是用-2來取模有可能會出現負數，因此我們得阻止複數出現。
     若a/b的商是c且餘數是d，我們可以得知a = bc + d
     故d = a - bc 我們要確保d為正。
     假設b = -r
     上面的式子可以寫為
     d = a + rc
     a = -rc + d
     a = -rc + d + r -r
     a = -r(c+1) + (d + r)
     因此遇到負數的d時， 商加上1, d + r (r 的話 這裡是2)
    */
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    String res = "";
    if (n == 0) {
      System.out.println("0");
      System.exit(0);
    } else {
      while (n != 0) {
        int d = n % BASE;
        n /= BASE;
        if (d < 0) {
          d = d - BASE;
          n++;
        }
        res = d + res;
      }
    }
    System.out.println(res);
    System.exit(0);
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
