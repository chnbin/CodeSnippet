
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
    int a = sc.nextInt();
    String s = sc.next();
    if (a < 3200) {
      System.out.println("red");
    } else {
      System.out.println(s);
    }
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    double res = 0.0;
    for (int i = 0; i < n; i++) {
      res += 1/sc.nextDouble();
    }
    System.out.println(1/res);
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    Arrays.sort(nums);
    double res = (nums[0]*1.0 + nums[1]*1.0) / 2;
    for (int i = 2; i < n; i++) {
      res = (res + nums[i] * 1.0) / 2;
    }

    System.out.println(res);
  }

  private static void notSolveD() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int q = sc.nextInt();
    
    // Key is child, value is root
    Map<Integer, Integer> tree = new HashMap<>();
    long[] counter = new long[n+1];
    
    
    // Build tree
    for (int i = 0; i < n - 1; i++) {
      int v = sc.nextInt();
      int w = sc.nextInt();
      tree.put(w, v);

    }
    
    for (int i = 0; i < q; i++) {
      int v = sc.nextInt();
      int weight = sc.nextInt();
      counter[v] += weight;
    }
    
    // Compute all node's counter from node 2 (node 1 is root)
    for (int i = 2; i <= n; i++) {
      counter[i] += counter[tree.get(i)];
    }
    
    for (int i = 1; i < counter.length; i++) {
      if (i == counter.length - 1) {
        System.out.println(counter[i]);
      } else {
        System.out.print(counter[i] + " ");
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
