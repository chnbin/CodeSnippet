import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// AtCoder Beginner Contest 086
	// https://atcoder.jp/contests/abc086/tasks
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = 0;
		
		if (b >= 0 && b <= 9) {
			c = a * 10 + b;
		} else if (b >= 10 && b <= 99) {
			c = a * 100 + b;
		} else {
			c = a * 1000 + b;
		}
		double d = Math.sqrt(c*1.0);
		if ((int)d - d == 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
	
	private static void a() {
		FastReader sc = new FastReader();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if ((a*b) % 2 == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
	}
	
	private static void b() {
		FastReader sc = new FastReader();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = 0;
		
		if (b >= 0 && b <= 9) {
			c = a * 10 + b;
		} else if (b >= 10 && b <= 99) {
			c = a * 100 + b;
		} else {
			c = a * 1000 + b;
		}
		double d = Math.sqrt(c*1.0);
		if ((int)d - d == 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
	
	private static void c() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int prevT = 0;
		int prevX = 0;
		int prevY = 0;
		
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int dist = Math.abs(x - prevX) + Math.abs(y - prevY);
			int timeDiff = t - prevT;
			
			if (dist > timeDiff || (dist % 2 != timeDiff % 2)) {
				System.out.println("No");
				System.exit(0);
			}
			prevT = t;
			prevX = x;
			prevY = y;
		}
		
		System.out.println("Yes");
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
