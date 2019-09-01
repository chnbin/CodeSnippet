
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  final static int MOD = 10007;

  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
  }
  

  private static void solveA() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int x = sc.nextInt();
    System.out.println((n*1.0)/(x*1.0));
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int[] lengths = new int[n];
    int maxLengths = 0;
    int sumLengths = 0;
    
    for (int i = 0; i < n; i++) {
      int length = sc.nextInt();
      maxLengths = Math.max(maxLengths, length);
      sumLengths += length;
    }
    
    if ((sumLengths - maxLengths) > maxLengths) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] loc = new int[m];
    for (int i = 0 ; i < m; i++) {
      loc[i] = sc.nextInt();
    }
    
    Arrays.sort(loc);
    
    // 1 <= i <= M - 1, distance[i] = |loc[i] - loc[i-1]|
    int[] distance = new int[m - 1];
    for (int i = 1; i < m; i++) {
      distance[i-1] = Math.abs(loc[i] - loc[i-1]);
    }
    
    Arrays.sort(distance);
    int res = 0;
    
    /* 以範例一為例： 入力例１を例として
    1 2 10 12 14
     1 2  2  8  <= 如果陀螺只有一顆，得全走，陣列全部總和　コマがただ一つの場合には、最も左の場所から、最も右の場所まで移動します。
     1 2  2  X  <= 如果陀螺有兩顆，其中一顆放距離最大那個，其他總和　コマが二つの場合には、一つのコマを一番長い距離の場所で置いて、
     　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　もう一つのコマは最も左の場所から、最も右の場所まで移動します
     1 2  X  X  <= 如果陀螺有三顆，其中兩顆放距離最大那兩個，其他總和　
      1  X    X  X  <= 如果陀螺有四‘顆，其中三顆放距離最大那三個，其他總和
    */
    for (int i = 0; i < m - n; i++) {
      res += distance[i];
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
