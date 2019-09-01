
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		if (Math.abs(c - a) <= d) {
			System.out.println("Yes");
		} else {
			if (Math.abs(b - a) <= d && Math.abs(c - b) <= d) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
  }

  private static void solveB() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		List<Integer> res = new ArrayList<>();
		res.add(1);
		for (int i = 2; i <= (int)Math.sqrt(n * 1.0) + 1; i++) {
			int num = i;
			int temp = 1;
			while (temp < n) {
				temp *= num;
				if (temp <= n) {res.add(temp);}
			}
		}
		
		Collections.sort(res);
		System.out.println(res.get(res.size()-1));
  }

  private static void solveC() {
		FastReader sc = new FastReader();
		String s = sc.next();
		int k = sc.nextInt();
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = 1; j <= Math.min(k, s.length()-i); j++) {
				set.add(s.substring(i, i+j));
			}
		}
		List<String> res = new ArrayList<>(set);
		Collections.sort(res);

		
		System.out.println(res.get(k-1));
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
