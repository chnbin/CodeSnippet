
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  final static int MOD = 10007;

  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
    solveD();
  }
  

  private static void solveA() {
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    
    System.out.println((a * b) * 2 + (b * c) * 2 + (c * a) * 2);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int x = sc.nextInt();
    double res = Math.sqrt(x*1.0);
    res = Math.sqrt(res*1.0);
    
    System.out.println((int)res);
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    String keyboard = "WBWBWWBWBWBWWBWBWWBWBWBWWBWBWWBWBWBW";
    String[] table = {"Do","Do","Re","Re","Mi","Fa","Fa","So", "So", "La", "La", "Si"};
    String s = sc.next();
    int idx = keyboard.indexOf(s);
    System.out.println(table[idx]);
  }

  private static void solveD() {
     FastReader sc = new FastReader();
    long n = sc.nextLong();
    long m = n - 1;
    long res = ((1 + m) * m)/2;
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
