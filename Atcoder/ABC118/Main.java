
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// AtCoder Beginner Contest 118
	// https://atcoder.jp/contests/abc118/tasks
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int[] monster = new int[n];
		int res = 0;
		
		for (int i = 0; i < n; i++) {
			monster[i] = sc.nextInt();
		}
		res = gcd(monster[0], monster[1]);
		
		for (int i = 2; i < n; i++) {
			res = gcd(res, monster[i]);
		}
		
		System.out.println(res);
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
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if (b % a == 0) {
			System.out.println(a + b);
		} else {
			System.out.println(b - a);
		}
	}
	
	private static void b() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] foods = new int[m+1];
		int res = 0;
		
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			
			for (int j = 0; j < k; j++) {
				int f = sc.nextInt();
				foods[f]++;
			}
		}
		
		for (int i = 1; i <= m; i++) {
			if (foods[i] == n) {
				res++;
			}
		}
		
		System.out.println(res);
	}
	
	private static void c() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int[] monster = new int[n];
		int res = 0;
		
		for (int i = 0; i < n; i++) {
			monster[i] = sc.nextInt();
		}
		res = gcd(monster[0], monster[1]);
		
		for (int i = 2; i < n; i++) {
			res = gcd(res, monster[i]);
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
