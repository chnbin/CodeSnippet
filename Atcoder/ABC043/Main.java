
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
    int n = sc.nextInt();
    System.out.println(((1 + n) * n) / 2);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    String s = sc.next();
    String t = sc.next();
    StringBuilder res = new StringBuilder();
    
    int sPos = 0;
    int tPos = 0;
    
    while (sPos < s.length() || tPos < t.length()) {
      if (sPos < s.length()) {
        res.append(s.charAt(sPos));
        sPos++;
      }
      if (tPos < t.length()) {
        res.append(t.charAt(tPos));
        tPos++;
      }
    }
    System.out.println(res.toString());
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    LinkedList<Character> stack = new LinkedList<>();
    String s = sc.next();
    String res = "";
    
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'B') {
          if (!stack.isEmpty()) {
            stack.pop();
          }
        } else {
          stack.push(s.charAt(i));
        }
    }
                       
    while (!stack.isEmpty()) {
      res = stack.pop() + res;
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
