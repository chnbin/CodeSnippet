import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	// AtCoder Beginner Contest 116
	// https://atcoder.jp/contests/abc116/tasks
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int s = sc.nextInt();
		int idx = 1;
		Set<Integer> set = new HashSet<>();
		set.add(s);
		
		while (true) {
			idx++;
			if (s % 2 == 0) {
				s /= 2;
			} else {
				s = (3 * s) + 1;
			}
			
			if (set.contains(s)) {
				System.out.println(idx);
				System.exit(0);
			} else {
				set.add(s);
			}
		}
	}
	
	private static void a() {
		FastReader sc = new FastReader();
		int ab = sc.nextInt();
		int bc = sc.nextInt();
		int ca = sc.nextInt();
		System.out.println((ab * bc) / 2);
	}
	
	private static void b() {
		FastReader sc = new FastReader();
		int s = sc.nextInt();
		int idx = 1;
		Set<Integer> set = new HashSet<>();
		set.add(s);
		
		while (true) {
			idx++;
			if (s % 2 == 0) {
				s /= 2;
			} else {
				s = (3 * s) + 1;
			}
			
			if (set.contains(s)) {
				System.out.println(idx);
				System.exit(0);
			} else {
				set.add(s);
			}
		}
	}
	
	private static void c() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int prevH = 0;
		int res = 0;
		
		for (int i = 0; i < n; i++) {
			int height = sc.nextInt();
			
			if (height > prevH) {
				res += (height - prevH);
			}
			prevH = height;
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
