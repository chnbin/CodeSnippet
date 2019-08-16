
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
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
    String s = sc.next();
    int n = sc.nextInt();
    System.out.println(s.charAt(n-1));
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    Long K = (long)Math.pow(10.0, 9) + 7;

    long a = sc.nextLong();
    long b = sc.nextLong();
    long c = sc.nextLong();
  
    System.out.println(((a * b)% K)*(c % K) % K);
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int[] heights = new int[n];
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < heights.length; i++) {
      int h = sc.nextInt();
      heights[i] = h;
      map.put(h, i+1);
    }
    Arrays.sort(heights);
    
    for (int i = heights.length - 1; i >= 0; i--) {
      System.out.println(map.get(heights[i]));
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
