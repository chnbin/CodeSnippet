import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  // AtCoder Beginner Contest 129
  // https://atcoder.jp/contests/abc129/tasks
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
    if (b > a) { b = a; }
    if (c < (a - b)) {
      System.out.println("0");
    } else {
      System.out.println(c- (a -b));
    }
  }
  
  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int res = 0;
    
    for (int i = 1 ; i <= n; i++) {
      if (String.valueOf(i).length() % 2 == 1) {
        res++;
      }
    }
    System.out.println(res);
  }
  
  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    long[] dp = new long[n+1];
    int m = sc.nextInt();
    
    for (int i = 0; i< m; i++) {
      int a = sc.nextInt();
      dp[a] = -1;
    }
    
    dp[0] = (dp[0] == 0) ? 1 : -1;
    dp[1] = (dp[1] == 0) ? 1 : -1;
    
    for (int i = 2; i < dp.length;i++) {
      if (dp[i] != -1) {
        long step1 = (dp[i-1] == -1) ? 0 : dp[i-1];
        long step2 = (dp[i-2] == -1) ? 0 : dp[i-2];
        
        dp[i] = (step1 + step2) % MOD;
      }
      
    }
    
    System.out.println(dp[dp.length-1]);
  }
  
  private static void solveD() {
    FastReader sc = new FastReader();
    int h = sc.nextInt();
    int w = sc.nextInt();
    char[][] room = new char[h][w];
    int[][] down = new int[h][w];
    int[][] up = new int[h][w];
    int[][] left = new int[h][w];
    int[][] right = new int[h][w];
    int res = 0;
    
    for (int i = 0; i < h; i++) {
      String s = sc.next();
      for (int j = 0; j < w; j++) {
        room[i][j] = s.charAt(j);
      }
    }
    
    // Down
    for (int j = 0; j < w; j++) {
      int light = 0;
      for(int i = 0; i < h; i++) {
        if (room[i][j] == '#') {
          light = 0;
        } else {
          light++;
          down[i][j] = light;
        }
      }
    }
    
    // Up
    for (int j = 0; j < w; j++) {
      int light = 0;
      for(int i = h - 1; i >= 0; i--) {
        if (room[i][j] == '#') {
          light = 0;
        } else {
          light++;
          up[i][j] = light;
        }
      }
    }
    
    // Left
    for (int i = 0; i < h; i++) {
      int light = 0;
      for(int j = 0; j < w; j++) {
        if (room[i][j] == '#') {
          light = 0;
        } else {
          light++;
          left[i][j] = light;
        }
      }
    }
    
    // Right
    for (int i = 0; i < h; i++) {
      int light = 0;
      for(int j = w - 1; j >= 0; j--) {
        if (room[i][j] == '#') {
          light = 0;
        } else {
          light++;
          right[i][j] = light;
        }
      }
    }
    
    // for (int i = 0; i < h; i++) {
    //  System.out.println(Arrays.toString(right[i]));
    // }
    
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (room[i][j] != '#') {
          int currLight = left[i][j]+right[i][j]+up[i][j]+down[i][j] - 3;
          res = Math.max(res, currLight);
        }
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
