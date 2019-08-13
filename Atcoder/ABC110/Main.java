
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  // AtCoder Beginner Contest 110
  // https://atcoder.jp/contests/abc110/tasks
  public static void main(String[] args) {
	  FastReader sc = new FastReader();
	  int n = sc.nextInt();
	  int m = sc.nextInt();
	  int x = sc.nextInt();
	  int y = sc.nextInt();
	  
	  int[] numX = new int[n];
	  int[] numY = new int[m];
	  
	  for (int i = 0; i < n; i++) {
		  numX[i] = sc.nextInt();
	  }
	  
	  for (int i = 0; i < m; i++) {
		  numY[i] = sc.nextInt();
	  }
	  
	  Arrays.sort(numX);
	  Arrays.sort(numY);
	  
	  for (int i = x + 1; i <= y; i++) {
		  if (numX[n-1] < i && i <= numY[0]) {
			  System.out.println("No War");
			  System.exit(0);
		  }
	  }
	  System.out.println("War");
	  System.exit(0);
  }
  
  private static void solveA() {
	  FastReader sc = new FastReader();
	  int first = Integer.MIN_VALUE;
	  int second = Integer.MIN_VALUE;
	  int third = Integer.MIN_VALUE;
	  
	  for (int i = 0; i < 3; i++) {
		  int n = sc.nextInt();
		  if (n > first) {
			  third = second;
			  second = first;
			  first = n;
		  } else if (n > second) {
			  third = second;
			  second = n;
		  } else if (n > third) {
			  third = n;
		  }
	  }
	  
	  System.out.println(first*10 + second + third);
	  System.exit(0);
  }
  
  private static void solveB() {
	  FastReader sc = new FastReader();
	  int n = sc.nextInt();
	  int m = sc.nextInt();
	  int x = sc.nextInt();
	  int y = sc.nextInt();
	  
	  int[] numX = new int[n];
	  int[] numY = new int[m];
	  
	  for (int i = 0; i < n; i++) {
		  numX[i] = sc.nextInt();
	  }
	  
	  for (int i = 0; i < m; i++) {
		  numY[i] = sc.nextInt();
	  }
	  
	  Arrays.sort(numX);
	  Arrays.sort(numY);
	  
	  for (int i = x + 1; i <= y; i++) {
		  if (numX[n-1] < i && i <= numY[0]) {
			  System.out.println("No War");
			  System.exit(0);
		  }
	  }
	  System.out.println("War");
	  System.exit(0);
  }
  
  private static void solveC() {
	  FastReader sc = new FastReader();
	  String s = sc.next();
	  String t = sc.next();
	  int[] sCharCnt = new int[26];
	  int[] tCharCnt = new int[26];
	  
	  for (int i = 0; i < s.length(); i++) {
		  sCharCnt[s.charAt(i) - 'a']++;
		  tCharCnt[t.charAt(i) - 'a']++;
	  }
	  
	  Arrays.sort(sCharCnt);
	  Arrays.sort(tCharCnt);
	  
	  List<Integer> sl = new ArrayList<>();
	  List<Integer> tl = new ArrayList<>();
	  
	  for (int i = 0; i < sCharCnt.length; i++) {
		  if (sCharCnt[i] != 0) { sl.add(sCharCnt[i]); }
		  if (tCharCnt[i] != 0) { tl.add(tCharCnt[i]); }
	  }
	  
	  if (sl.size() != tl.size()) {
		  System.out.println("No");
		  System.exit(0);
	  } else {
		  for (int i = 0; i < sl.size(); i++) {
			  if (sl.get(i).intValue() != tl.get(i).intValue()) {
				  System.out.println("No");
				  System.exit(0);
			  }
		  }
	  }
	  System.out.println("Yes");
	  System.exit(0);
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
