
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
