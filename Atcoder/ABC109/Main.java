
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  // Atcode Beginner Contest 109
  // https://atcoder.jp/contests/abc109/tasks
  public static void main(String[] args) {
	  FastReader sc = new FastReader();
	  int n = sc.nextInt();
	  Set<String> set = new HashSet<>();
	  String word = sc.next();
	  char shiri = word.charAt(word.length()-1);
	  set.add(word);
	  
	  for (int i = 1; i < n; i++) {
		  String w = sc.next();
		  char sentou = w.charAt(0);
		  
		  if (sentou != shiri || set.contains(w)) {
			  System.out.println("No");
			  System.exit(0);
		  }
		  shiri = w.charAt(w.length()-1);
		  set.add(w);
	  }
	  
	  System.out.println("Yes");
	  System.exit(0);
  }
  
  private static void solveA() {
	  FastReader sc = new FastReader();
	  int a = sc.nextInt();
	  int b = sc.nextInt();
	  	  
	  if ((a*b) % 2 == 0) {
		  System.out.println("No");
		  System.exit(0);
	  }
	  
	  System.out.println("Yes");
	  System.exit(0);
  }
  
  private static void solveB() {
	  FastReader sc = new FastReader();
	  int n = sc.nextInt();
	  Set<String> set = new HashSet<>();
	  String word = sc.next();
	  char shiri = word.charAt(word.length()-1);
	  set.add(word);
	  
	  for (int i = 1; i < n; i++) {
		  String w = sc.next();
		  char sentou = w.charAt(0);
		  
		  if (sentou != shiri || set.contains(w)) {
			  System.out.println("No");
			  System.exit(0);
		  }
		  shiri = w.charAt(w.length()-1);
		  set.add(w);
	  }
	  
	  System.out.println("Yes");
	  System.exit(0);
  }
  
  private static void solveC() {
	  FastReader sc = new FastReader();
	  int n = sc.nextInt();
	  int[] nums = new int[n+1];
	  nums[0] = sc.nextInt();
	  
	  for (int i = 1; i < n + 1; i++) {
		  nums[i] = sc.nextInt();
	  }
	    
	  Arrays.sort(nums);
	  if (nums.length == 2) {
		  System.out.println(nums[1] - nums[0]);
		  System.exit(0);
	  }
	  int gcd = nums[1] - nums[0];
	  int distance = nums[1] - nums[0];
	  boolean isAllTheSame = true;
	  
	  for (int i = 2; i < nums.length; i++) {
		  int d = nums[i] - nums[i-1];
		  gcd = gcd(gcd, d);
		  if (d != distance) { isAllTheSame = false; }
		  distance = d;
	  }
	  
	  if (isAllTheSame) {
		  System.out.println(distance);
		  System.exit(0);
	  }
	  
	  System.out.println(gcd);
	  System.exit(0);
  }
  
  private static int gcd(int m, int n) {
	  if (m < n) {
		  return gcd(n, m);
	  }
	  
	  if (n == 0) {
		  return m;
	  }
	  
	  return gcd(n, m % n);
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
