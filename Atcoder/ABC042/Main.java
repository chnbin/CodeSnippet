
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
    int cnt5 = 0;
    int cnt7 = 0;
    int a = sc.nextInt();
    cnt5 = (a == 5) ? cnt5 + 1:cnt5;
    cnt7 = (a == 7) ? cnt7 + 1:cnt7;
    int b = sc.nextInt();
    cnt5 = (b == 5) ? cnt5 + 1:cnt5;
    cnt7 = (b == 7) ? cnt7 + 1:cnt7;
    int c = sc.nextInt();
    cnt5 = (c == 5) ? cnt5 + 1:cnt5;
    cnt7 = (c == 7) ? cnt7 + 1:cnt7;
  
    if (cnt5 == 2 && cnt7 == 1) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int l = sc.nextInt();
    String[] strs = new String[n];
    
    for (int i = 0; i < n; i++) {
      strs[i] = sc.next();
    }
    
    Arrays.sort(strs);
    
    for(String str: strs) {
      System.out.print(str);
    }
    System.out.println("");
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int k = sc.nextInt();
    boolean[] hate = new boolean[10];
    
    for (int i = 0; i < k; i++) {
      int digit = sc.nextInt();
      hate[digit] = true;
    }
    
    for (int i = n; i < 10*n; i++) {
      int num = i;
      boolean isHate = false;
      
      while (num > 0) {
        int m = num % 10;
        if (hate[m]) {
          isHate = true;
          break;
        }
        num /= 10;
      }
      
      if (!isHate) {
        System.out.println(i);
        System.exit(0);
      }
    }
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
