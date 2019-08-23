
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // AtCoder Beginner Contest 079
  // https://atcoder.jp/contests/abc079/tasks
  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
    solveD();
  }
  
  public static void solveA() {
    FastReader sc = new FastReader();
    String str = sc.next();
    
    if ((str.charAt(0) == str.charAt(1) && str.charAt(1) == str.charAt(2)) || (str.charAt(1) == str.charAt(2) && str.charAt(2) == str.charAt(3))) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
  
  public static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    long[] lucas = new long[n+1];
    lucas[0] = 2;
    lucas[1] = 1;
    
    for (int i = 2; i <= n; i++) {
      lucas[i] = lucas[i-1] + lucas[i-2];
    }
    System.out.println(lucas[n]);
  }
  
  public static void solveC() {
    FastReader sc = new FastReader();
    String ticket = sc.next();
    int[] tickets = new int[ticket.length()];
    
    for (int i = 0; i < ticket.length(); i++) {
      tickets[i] = ticket.charAt(i) - '0';
    }
    findTicket(tickets, "" + tickets[0], 1, tickets[0]);
  }
  
  private static void findTicket(int[] nums, String s, int curr, int sum) {
    if (s.length() == 7) {
      if (sum == 7) {
        System.out.println(s + "=7");
        System.exit(0);
      } 
    } else {
      if (curr < nums.length) {
        findTicket(nums, s + "+" + nums[curr], curr+1, sum + nums[curr]);
        findTicket(nums, s + "-" + nums[curr], curr+1, sum - nums[curr]);
      }
    }
    
  }
  
  public static void solveD() {
    FastReader sc = new FastReader();
    int h = sc.nextInt();
    int w = sc.nextInt();
    long res = 0;
    long[][] floyd = new long[10][10];
    
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        floyd[i][j] = sc.nextLong();
      }
    }
    
    for (int k = 0; k < 10; k++) {
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
        }
      }
    }
    
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        int wall = sc.nextInt();
        if (wall != -1) {
          res += floyd[wall][1];
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
