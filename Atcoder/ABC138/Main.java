
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
  	// TLE
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int q = sc.nextInt();
    int[] val = new int[n+1];
    
    HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
    // tree.put(1, new ArrayList<Integer>());
    
    for (int i = 1; i < n; i++) {
      int r = sc.nextInt();
      int c = sc.nextInt();
      
      for (int j = 1; j <= n; j++) {
        if (j == r) {
          if (!tree.containsKey(j)) {
            tree.put(j, new ArrayList<Integer>());
          }
          tree.get(j).add(c);
          if (!tree.containsKey(c)) {
            tree.put(c, new ArrayList<Integer>());
          }
        }
      }
    }
    
    for (int i = 0; i <q; i++) {
      int node = sc.nextInt();
      int value = sc.nextInt();
      
      for (int j = 1; j <= n; j++) {
        if (j == node) {
          val[j] += value;
          dfs(tree, tree.get(j), val, value);
        }
      }
      
    }
    
    for (int i = 1; i < val.length; i++) {
      if (i == val.length) {
        System.out.println(val[i]);
      } else {
        System.out.print(val[i] + " ");
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
