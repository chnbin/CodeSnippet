
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
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
    int n = sc.nextInt();
    int x = sc.nextInt();
    
    System.out.println(Math.max(n - x, 0));
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    String s = sc.next();
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < s.length(); i++) {
      if (i % 2 == 0) {
        sb.append(s.charAt(i));
      }
    }
    
    System.out.println(sb.toString());
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;

    // 對於每個元素只有三個動作，加1，減1，不變。
    // 因此我們遇到任何一個數字x，就把(x - 1), x (x + 1)數量都加上1，(x - 1)不可以為負數。
    // 最後對於所有value中最大那個就是答案
    for (int i = 0; i < n; i++) {
      int curr = sc.nextInt();
      int prev = curr - 1;
      int next = curr + 1;

      if (prev >= 0) { map.put(prev, map.getOrDefault(prev, 0) + 1); }
      map.put(curr, map.getOrDefault(curr, 0) + 1);
      map.put(next, map.getOrDefault(next, 0) + 1);
    }
    for (int v: map.values()) {
      res = Math.max(res, v);
    }
    System.out.println(res);
  }

  private static void solveD() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int[] nums = new int[n+2];
    int cnt = 0;
    
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      nums[i+1] = num;
      if (num == (i+1)) { cnt++; }
    }
    
    if (cnt == 0) {
      System.out.println(cnt);
      System.exit(0);
    }
    cnt = 0;
    
    for (int i = 1; i <= n; i++) {
      if (nums[i] == i) {
        cnt++;
        int tmp = nums[i];
        nums[i] = nums[i+1];
        nums[i+1] = tmp;
      }
    }
    
    System.out.println(cnt);
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
