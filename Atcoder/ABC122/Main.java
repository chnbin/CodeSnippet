
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // AtCoder Beginner Contest 122
  // https://atcoder.jp/contests/abc122/tasks
  public static void main(String[] args) {
    FastReader sc = new FastReader();
    String str = sc.next();
    
    switch (str) {
      case "A":
        System.out.println("T");
        break;
      case "C":
        System.out.println("G");
        break;
      case "G":
        System.out.println("C");
        break;
      case "T":
        System.out.println("A");
        break;
    }
  }
  
  private void a() {
    FastReader sc = new FastReader();
    String str = sc.next();
    
    switch (str) {
      case "A":
        System.out.println("T");
        break;
      case "C":
        System.out.println("G");
        break;
      case "G":
        System.out.println("C");
        break;
      case "T":
        System.out.println("A");
        break;
    }
  }
  
  private void b() {
    FastReader sc = new FastReader();
    String s = sc.next();
    
    int begin = 0;
    int end = 0;
    int res = 0;
    
    while (end < s.length()) {
      char c = s.charAt(end);
      if (c == 'A' || c == 'C' || c == 'G' || c == 'T') {
        res = Math.max(res, end - begin + 1);
        end++;
      } else {
        end++;
        begin = end;
      }
    }
    System.out.println(res);
  }

  private void c() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int q = sc.nextInt();
    String str = sc.next();
    int[] pre = new int[n];
    
    for (int i = 1; i < n; i++) {
      int inc = 0;
      if (str.charAt(i) == 'C' && str.charAt(i-1) == 'A') {
        inc = 1; 
      }
      pre[i] = pre[i-1] + inc;
    }
    
    for (int i = 0; i < q; i++) {
      int l = sc.nextInt() - 1;
      int r = sc.nextInt() - 1;
      System.out.println(pre[r] - pre[l]);
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
