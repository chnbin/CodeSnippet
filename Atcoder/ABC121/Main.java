
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	// AtCoder Beginner Contest 121
	// https://atcoder.jp/contests/abc121/tasks
	public static void main(String[] args) {
	}
	
	private void a() {
		FastReader sc = new FastReader();
		int H = sc.nextInt();
		int W = sc.nextInt();
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		System.out.println((H-h)*(W-w));
	}
	
	private void b() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int c = sc.nextInt();
		int[] b = new int[m];
		int res = 0;
		
		for (int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			int total = 0;
			int[] k = new int[m];
			for (int j = 0; j < m; j++) {
				k[j] = sc.nextInt();
			}
			
			for (int l = 0; l < m; l++) {
				total += (k[l] * b[l]);
			}
			if (total + c > 0) { 
				res++;
			}
		}
		
		System.out.println(res);
	}
	
	private void c() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int m = sc.nextInt();
		long res = 0;
		int[][] stores = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			stores[i][0] = sc.nextInt();
			stores[i][1] = sc.nextInt();
		}
		
		Arrays.sort(stores, (a , b) -> (a[0] - b[0]));
		
		for (int i = 0; i < n; i++) {
			long buy = Math.min(m, stores[i][1]);
			res += (long)(buy * stores[i][0]);
			m -= (int)buy;
			if (m == 0) { break; }
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
