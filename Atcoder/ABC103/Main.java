
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
    solveD();
  }
  

  private static void solveA() {
  FastReader sc = new FastReader();
    int[] nums = new int[3];
    
    for (int i = 0; i < 3; i++) {
      nums[i] = sc.nextInt();
    }
    Arrays.sort(nums);
    
    System.out.println((nums[1] - nums[0]) + (nums[2] - nums[1]));
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    String s = sc.next();
    String t = sc.next();
    s += s;
    
    if (s.indexOf(t) == -1) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    long res = 0;
    
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      res += (num - 1);
    }
    
    System.out.println(res);
  }

  private static void solveD() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] ab = new int[m][2];
    
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      ab[i][0] = a;
      ab[i][1] = b;
    }
    
    Arrays.sort(ab, (x, y) -> y[0] - x[0]);
    int res = 0;
    int prev = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
      System.out.println(Arrays.toString(ab[i]));
    }
    
    for (int i = 0; i < m; i++) {
      if (prev >= ab[i][1]) {
        prev = ab[i][0];
        res++;
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
