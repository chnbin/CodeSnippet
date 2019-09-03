
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
    solveD();
  }
  

  private static void solveA() {
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    
    System.out.println((a * b) * 2 + (b * c) * 2 + (c * a) * 2);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    int x = sc.nextInt();
    double res = Math.sqrt(x*1.0);
    res = Math.sqrt(res*1.0);
    
    System.out.println((int)res);
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    String keyboard = "WBWBWWBWBWBWWBWBWWBWBWBWWBWBWWBWBWBW";
    String[] table = {"Do","Do","Re","Re","Mi","Fa","Fa","So", "So", "La", "La", "Si"};
    String s = sc.next();
    int idx = keyboard.indexOf(s);
    System.out.println(table[idx]);
  }

  private static void solveD() {
    FastReader sc = new FastReader();
    int h = sc.nextInt();
    int w = sc.nextInt();
    char[][] image = new char[h][w];
    
    int[][] directions = {
        {-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
    
    for (int i = 0; i < h; i++) {
      String row = sc.next();
      for (int j = 0; j < row.length(); j++) {
        image[i][j] = row.charAt(j);
      }
    }
    
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        char c = image[i][j];
        if (c == '#' || c == 'f') {
          int pixels = 0;
          int blackPixels = 0;
          
          for (int k = 0; k < directions.length; k++) {
            int dx = i + directions[k][0];
            int dy = j + directions[k][1];
            if ((0 <= dx) && (dx < h) && (0 <= dy) && (dy < w)) {
              pixels++;
              if (image[dx][dy] == '#' || image[dx][dy] == 'F' || image[dx][dy] == 'f') {
                blackPixels++;
              }
            }
          }
          
          if (pixels == blackPixels) {
            image[i][j] = 'F';
            for (int k = 0; k < directions.length; k++) {
              int dx = i + directions[k][0];
              int dy = j + directions[k][1];
              if ((0 <= dx) && (dx < h) && (0 <= dy) && (dy < w) && image[dx][dy] != 'F') {
                image[dx][dy] = 'f';
              }
            }
          }
        }
      }
    }
    
    boolean isBlackPixelsExist = false;
    
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (image[i][j] == 'F') {
          image[i][j] = '#';
        } else if (image[i][j] == 'f') {
          image[i][j] = '.';
        } else if (image[i][j] == '#') {
          isBlackPixelsExist = true;
        }
      }
    }
    
    if (isBlackPixelsExist) {
      System.out.println("impossible");
    } else {
      System.out.println("possible");
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          System.out.print(image[i][j]);
        }
        System.out.println("");
      }
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
