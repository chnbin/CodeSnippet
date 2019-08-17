
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
  }
  

  private static void solveA() {
		FastReader sc = new FastReader();
		String s = sc.next();
		int res = 0;
		
		for (char c: s.toCharArray()) {
			if (c == '+') {
				res++;
			} else {
				res--;
			}
		}
		System.out.println(res);
  }

  private static void solveB() {
    FastReader sc = new FastReader();
		String s = sc.next();
		int n = 0;
		int total = 0;
		
		for (char c: s.toCharArray()) {
			int num = c - '0';
			total *= 10;
			total += num;
			n += num;
		}
		
		if (total % n == 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
  }

  private static void solveC() {
			FastReader sc = new FastReader();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] p = new int[n];
		
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		
		System.out.println((int)Math.ceil((double)(n-1)/(double)(k-1)));
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
