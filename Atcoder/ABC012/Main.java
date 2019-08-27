
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    int m = sc.nextInt();
    int tmp = n;
    n = m;
    m = tmp;
    System.out.println(n + " " + m);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int h = n / 3600;
    int m = (n % 3600) / 60;
    int s = (n % 60);
    System.out.format("%02d:%02d:%02d", h, m, s);
  }


  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    
    // 2025 是 99乘法表 1X1 ... 9X9 的總和
    int num = 2025 - n;
    int k = 1;
    
    while (k <= num && k <= 9) {
      if (num % k == 0) {
        int m = num / k;
        if (m <= 9) {
          System.out.println(k + " x " + m);
        }
      }
      k++;
    }
  }

  private static int computeArea(char[][] room, int x, int y) {
    int res = 0;
    if ((0 <= x) && (x < room.length) && (0 <= y) && (y < room[0].length)) {
      if (room[x][y] == '.') { return res; }
      room[x][y] = '.';
      res += 1;
      res += computeArea(room, x - 1, y);
      res += computeArea(room, x + 1, y);
      res += computeArea(room, x, y - 1);
      res += computeArea(room, x, y + 1);
      return res;
    }
    return res;
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
