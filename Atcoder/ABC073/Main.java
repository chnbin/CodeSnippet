
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
  }
  

  private static void solveA() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    
    if ((n / 10) == 9 || (n % 10) == 9) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int res = 0;
    
    for (int i = 0; i < n; i++) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      
      res += (r - l) + 1;
    }
    
    System.out.println(res);
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    Set<Integer> set = new HashSet<>();
    
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      
      if (set.contains(num)) {
        set.remove(num);
      } else {
        set.add(num);
      }
    }
    System.out.println(set.size());
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
