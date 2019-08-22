
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  final static int MOD = 10007;

  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
  }
  

  private static void solveA() {
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    
    if (b - a == c - b) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    String s = sc.next();
    String t = sc.next();
    StringBuilder res = new StringBuilder();
    
    int sPos = 0;
    int tPos = 0;
    
    while (sPos < s.length() || tPos < t.length()) {
      if (sPos < s.length()) {
        res.append(s.charAt(sPos));
        sPos++;
      }
      if (tPos < t.length()) {
        res.append(t.charAt(tPos));
        tPos++;
      }
    }
    System.out.println(res.toString());
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int[][] charTable = new int[n][26];
    StringBuilder res = new StringBuilder();
    
    for (int i = 0; i < n; i++) {
      String s = sc.next();
      
      for (char c: s.toCharArray()) {
        charTable[i][c - 'a']++;
      }
    }
    
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < 26; j++) {
        charTable[0][j] = Math.min(charTable[0][j], charTable[i][j]);
      }
    }
    
    for (int i = 0; i <= 25; i++) {
      if (charTable[0][i] != 0) {
        for (int j = 0; j < charTable[0][i]; j++) {
          res.append((char)('a' + i));
        }
      }
    }
    System.out.println(res.toString());
    
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
