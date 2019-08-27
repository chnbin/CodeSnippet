
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
    int a = sc.nextInt();
    int b = sc.nextInt();
    int res = 0;
    
    if (a <= b) {
      res = a;
    } else {
      res = a - 1;
    }
    
    System.out.println(res);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int[] nums = new int[3];
    for (int i = 0; i < 3; i++) {
      nums[i] = sc.nextInt();
    }
    
    Arrays.sort(nums);
    
    int k = sc.nextInt();
    while (k > 0) {
      nums[2] *= 2;
      k--;
    }
    
    System.out.println(nums[0] + nums[1] + nums[2]);
  }


  private static void solveC() {
    FastReader sc = new FastReader();
    int h = sc.nextInt();
    int w = sc.nextInt();
    
    char[][] room = new char[h][w];
    
    for (int i = 0; i < h; i++) {
      String s = sc.next();
      for (int j = 0; j < w; j++) {
        room[i][j] = s.charAt(j);
      }
    }
    
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        char c = room[i][j];
        if (c == '#') {
          int area = computeArea(room, i, j);
          if (area == 1) {
            System.out.println("No");
            System.exit(0);
          }
        }
      }
    }
    System.out.println("Yes");
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
