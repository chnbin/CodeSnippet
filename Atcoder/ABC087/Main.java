
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// AtCoder Beginner Contest 087
	// https://atcoder.jp/contests/abc087/tasks
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int x = sc.nextInt();
		int res = 0;
		
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				for (int k = 0; k <= c; k++) {
					if (500 * i + 100 * j + 50 * k == x) {
						res++;
					}
				}
			}
		}
		
		System.out.println(res);
	}

	private static void a() {
		FastReader sc = new FastReader();
		int x = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println((x - a) % b);
	}
	
	private static void b() {
		FastReader sc = new FastReader();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int x = sc.nextInt();
		int res = 0;
		
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				for (int k = 0; k <= c; k++) {
					if (500 * i + 100 * j + 50 * k == x) {
						res++;
					}
				}
			}
		}
		
		System.out.println(res);
	}
	
	private static void c() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int[][] map = new int[2][n];
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					// Do not thing
				} else if (i == 0 && j > 0) {
					map[i][j] += map[i][j-1];
				} else if (i > 0 && j == 0) {
					map[i][j] += map[i-1][j];
				} else {
					map[i][j] += Math.max(map[i-1][j], map[i][j-1]);
				}
			}
		}
		
		System.out.println(map[1][n-1]);
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
