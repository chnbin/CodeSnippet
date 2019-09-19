import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
    solveD();
  }
  

  private static void solveA() {
    FastReader sc = new FastReader();
    Map<String, String> map = new HashMap<>();
    map.put("Sunny", "Cloudy");
    map.put("Cloudy", "Rainy");
    map.put("Rainy", "Sunny");
    String s = sc.next();
    System.out.println(map.get(s));
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    String rud = "RUD";
    String lud = "LUD";
    
    String s = sc.next();
    
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (i % 2 == 1) {
        if (c == 'R') {
          System.out.println("No");
          return ;
        } 
      } else {
        if (c == 'L') {
          System.out.println("No");
          return ;
        } 
      }
    }
    System.out.println("Yes");
    
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int k = sc.nextInt();
    int q = sc.nextInt();
    
    int[] player = new int[n+1];
    Arrays.fill(player, k);
    
    for (int i = 0; i < q; i++) {
      int getScore = sc.nextInt();
      player[getScore]++;
    }
    
    for (int i = 1; i <=n; i++) {
      int result = player[i] - q;
      if (result > 0) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
    
  }

  private static void solveD() {
    FastReader sc = new FastReader();
    long n = sc.nextLong();
    long m = sc.nextLong();
    long res = 0l;
    
    PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    for (int i = 0; i < n; i++) {
      long cost = sc.nextLong();
      pq.offer(cost);
    }
    
    while (m > 0) {
      pq.add(pq.poll() / 2);
      m--;
    }
    
    while (!pq.isEmpty()) {
      res += pq.poll();
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
