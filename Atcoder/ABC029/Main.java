import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    helper(n, "");
  }
  
  private static void solveA() {
      FastReader sc = new FastReader();
      String s = sc.next();
      System.out.println(s + "s");
  }

  private static void solveB() {
    int res = 0;
    FastReader sc = new FastReader();
    for (int i = 0; i < 12; i++) {
      String s = sc.next();
      if (s.indexOf("r") != -1 ) {
        res++;
      }
    }
    System.out.println(res);
  }
  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    helper(n, "");
  }

  private static void helper(int n, String str) {
    if (n == 0) {
      System.out.println(str);
      return;
    } else {
      helper(n-1, str + "a");
      helper(n-1, str + "b");
      helper(n-1, str + "c");
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
