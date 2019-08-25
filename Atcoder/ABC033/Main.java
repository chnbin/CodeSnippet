
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
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
    String s = sc.next();
    Set<Integer> set = new HashSet<>();
    for (char c: s.toCharArray()) {
      set.add(c - '0');
    }
    
    if (set.size() == 1) {
      System.out.println("SAME");
    } else {
      System.out.println("DIFFERENT");
    }
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    String[] machi = new String[n];
    int[] jinkuchi = new int[n];
    int sum = 0;
    String res = "atcoder";
    
    for (int i = 0; i < n; i++) {
      machi[i] = sc.next();
      jinkuchi[i] = sc.nextInt();
      sum += jinkuchi[i];
    }
    
    for (int i = 0; i < n; i++) {
      if (jinkuchi[i] > (sum / 2)) {
        res = machi[i];
        break;
      }
    }
    
    System.out.println(res);
  }


  private static void solveC() {
    FastReader sc = new FastReader();
    String s = sc.next();
    String[] formulas = s.split("\\+"); 
    int res = 0;
    LinkedList<Integer> stack = new LinkedList<>();
    
    for (String str: formulas) {
      if (str.indexOf("*") == -1 && !str.equals("0")) {
        // Only digit and not 0
        res++;
      } else {
        if (str.indexOf("0") == -1) {
          res++;  
        }
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
