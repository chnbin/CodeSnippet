
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    // Aacoder Beginner Contest 137
    // https://atcoder.jp/contests/abc137/
    // Problem D was not accepted.
  }

  private  static void solveA() {
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int res = 0 ;
    res = Math.max(a + b, Math.max(a - b, a*b));
    System.out.println(res);
  }

  private  static void solveB() {
    FastReader sc = new FastReader();
    int k = sc.nextInt();
    int x = sc.nextInt();
    
    int l = (x - (k - 1));
    int r = (x + (k - 1));

    if (l < -1000000) { l = -1000000; }
    if (r > 1000000) { r = 1000000; }

    for (int i = l; i <= r; i++) {
      if (i == r) {
        System.out.println(i);
      } else {
        System.out.print(i + " ");
       }
      }
  }

  private  static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    Map<String, Long> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String s = sc.next();
      char[] tmpChar = s.toCharArray();
      Arrays.sort(tmpChar);
      String key = new String(tmpChar);

      if (map.containsKey(key)) {
        if (map.get(key) == 0) {
          map.put(key, 1L);
        } else {
          map.put(key, map.get(key) + 1);
        }
      } else {
        map.put(key, 0L);
      }
    }
    long res = 0;

    for (String key: map.keySet()) {
      long a = map.get(key);
      res += (((a + 1) * a) / 2);
    }

    System.out.println(res);
  }

  private  static void solveD() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int m = sc.nextInt();
    long res = 0;

    PriorityQueue<Work> pq = new PriorityQueue<>((a, b) -> (b.earn - a.earn));

    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      Work w = new Work(a, b);
      pq.offer(w);
    }
    int day = 0;
    while (day < m && !pq.isEmpty()) {
      boolean isPicked = false;
      List<Work> list = new ArrayList<>();
      while (!isPicked && !pq.isEmpty()) {
        Work w = pq.poll();
        int spend = w.spend;

        if ((day + spend <= m)) {
          res += w.earn;
          isPicked = true;
        } else {
          list.add(w);
        }
    }

      for (int i = 0; i < list.size(); i++) {
        pq.add(list.get(i));
      }
      day++;
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

class Work {
  int spend;
  int earn;
  
  public Work(int spend, int earn) {
    this.spend = spend;
    this.earn = earn;
  }
}
