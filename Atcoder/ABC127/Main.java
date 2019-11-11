
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
    int x = sc.nextInt();
    int y = sc.nextInt();
    System.out.println(x + (y / 2));
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int t = sc.nextInt();
    int a = sc.nextInt();
    int[] h = new int[n];
    
    for (int i = 0; i < n; i++) {
      h[i] = sc.nextInt();
    }
    double near = Double.MAX_VALUE;
    int res = -1;
    
    for (int i = 0; i < n; i++) {
      double temperature = Math.abs(a*1.0 -(t*1.0 - h[i]*1.0*0.006));
      if (temperature < near) {
        near = temperature;
        res = i+1;
      }
    }
    
    System.out.println(res);
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int m = sc.nextInt();
    
    int[] count = new int[n+1];
    int[][] cities = new int[m][3];
    String[] res = new String[m];
    
    for (int i = 0; i < m; i++) {
      int P = sc.nextInt();
      int Y = sc.nextInt();
      
      cities[i] = new int[]{P, Y, i};
    }
    
    Arrays.sort(cities, (a, b) -> (a[1] - b[1]));
    
    for (int i = 0; i < m ; i++) {
      //System.out.println(Arrays.toString(cities[i]));
      count[cities[i][0]]++;
      String s = String.format("%06d%06d", cities[i][0], count[cities[i][0]]);
      res[cities[i][2]] = s;
    }
    
    for (String s: res) {
      System.out.println(s);
    }

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
