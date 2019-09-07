
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
    solveD();
  }
  

  private static void solveA() {
    FastReader sc = new FastReader();
    int m = sc.nextInt();
    System.out.println(48 - m);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    String s = sc.next();
    
    if (s.charAt(a) != '-') {
      System.out.println("No");
      System.exit(0);
    }
    
    for (int i = 0; i < s.length(); i++) {
      if (i != a) {
        if (!Character.isDigit(s.charAt(i))) {
          System.out.println("No");
          System.exit(0);
        }
      }
    }
    System.out.println("Yes");
    System.exit(0);
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int[][] t = new int[n-1][3];
    
    for (int i = 0; i < n - 1; i++) {
      t[i][0] = sc.nextInt();
      t[i][1] = sc.nextInt();
      t[i][2] = sc.nextInt();
    }
    
    for (int i = 0; i < n - 1; i++) {
      int res = 0;
      int c = t[i][0];
      int s = t[i][1];
      long arrive = c + s;
      
      for (int j = i + 1; j < n - 1; j++) {
        int readyToGo = t[j][1];
        
        if (arrive < readyToGo) {
          arrive = readyToGo + t[j][0];
        } else {
          if ((arrive - t[j][1]) % t[j][2] == 0) {
            arrive += t[j][0]; 
          } else {
            arrive = arrive + (t[j][2]) - ((arrive - t[j][1]) % t[j][2]) + t[j][0];
          }
        }
      }
      
      System.out.println(arrive);
    }
    System.out.println(0);
  }

  private static void solveD() {
    FastReader sc = new FastReader();
    boolean[] primes = new boolean[100002];
    int[] counts = new int[100002];
    Arrays.fill(primes, true);
    primes[0] = false;
    primes[1] = false;
    
    // pre-process
    // 1.エラトステネスの篩
    for (int i = 2; i < 100002; i++) {
      if (primes[i]) {
        for (int j = i * 2; j < 100002; j += i) {
          primes[j] = false;
        }
      }
    }
    
    // 2. 2017に似た数を計算
    for (int i = 2; i < 100002; i++) {
      if (primes[i] && primes[(i + 1) / 2]) {
        counts[i]++;
      }
    }
    
    // 3. prefix sum
    for (int i = 1; i < 100002; i++) {
      counts[i] += counts[i-1];
    }
    
    int q = sc.nextInt();
    
    for (int i = 0; i < q; i++) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      System.out.println(counts[r] - counts[l-1]);
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
