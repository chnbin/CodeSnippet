
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// AtCoder Beginner Contest 115
	// https://atcoder.jp/contests/abc115/tasks
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
	}
	
	private static int gcd(int m, int n) {
		if (n == 0) {
			return m;
		}
		
		if (m < n) {
			return gcd(n, m);
		}
		return gcd(n, m % n);
	}
	
	private static void a() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		
		if (n == 25) {
			System.out.println("Christmas");
		} else if (n == 24) {
			System.out.println("Christmas Eve");
		} else if (n == 23) {
			System.out.println("Christmas Eve Eve");
		} else {
			System.out.println("Christmas Eve Eve Eve");
		}
	}
	
	private static void b() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int maxPrice = 0;
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			int cost = sc.nextInt();
			maxPrice = Math.max(maxPrice, cost);
			sum += cost;
		}
		
		System.out.println(sum - (maxPrice / 2));
	}
	
	private static void c() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] trees = new int[n];
		int minDiff = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			trees[i] = sc.nextInt();
		}
		
		Arrays.sort(trees);

		for (int i = 0; i + k - 1 < n; i++) {
			minDiff = Math.min(minDiff, trees[i + k -1] - trees[i]);
		}
		
		System.out.println(minDiff);
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
