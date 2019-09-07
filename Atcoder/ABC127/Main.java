
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  private static final long MOD = (long)Math.pow(10, 9) + 7;
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
    int cost = b;
    
    if (a <= 5) {
      cost = 0;
    } else if (a >= 6 && a <=12) {
      cost = b / 2 ;
    }
    System.out.println(cost);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int r = sc.nextInt();
    int d = sc.nextInt();
    int total = sc.nextInt();
    
    for (int i = 0; i < 10; i++) {
      total = (r * total - d);
      System.out.println(total);
    }
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int m = sc.nextInt();
    int maxLeft = Integer.MIN_VALUE;
    int minRight = Integer.MAX_VALUE;
    
    for (int i = 0; i < m; i++) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      maxLeft = Math.max(maxLeft, l);
      minRight = Math.min(minRight, r);
    }
    
    if (minRight - maxLeft + 1 >= 0) {
      System.out.println(minRight - maxLeft + 1);
    } else {
      System.out.println("0");
    
  }

  private static void solveD() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int m = sc.nextInt();
    long res = 0l;
    int[][] q = new int[m][2];
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      pq.offer(a);
      res += a;
    }
    
    for (int i = 0; i < m; i++) {
      q[i][0] = sc.nextInt();
      q[i][1] = sc.nextInt();
    }
    Arrays.sort(q, (a, b) -> (b[1] - a[1]));
    
    for (int i = 0; i < m; i++) {
      int b = q[i][0];
      int c = q[i][1];
      int min = pq.peek();
      if (c < min) { break;}
      
      while (b > 0) {
        min = pq.poll();
        if (c > min) {
          pq.offer(c);
          res = res - min + c;
        } else {
          pq.offer(min);
          break;
        }
        b--;
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
