import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		// AtCoder Beginner Contest 038
		// https://atcoder.jp/contests/abc038/tasks/
		FastReader sc = new FastReader();
		int h1 = sc.nextInt();
		int w1 = sc.nextInt();
		int h2 = sc.nextInt();
		int w2 = sc.nextInt();
		
		if (h1 == h2 || w1 == w2 || h1 == w2 || h2 == w1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	private static void solveA() {
		FastReader sc = new FastReader();
		String s = sc.next();
		
		if (s.charAt(s.length() - 1) == 'T') {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static void solveB() {
		FastReader sc = new FastReader();
		int h1 = sc.nextInt();
		int w1 = sc.nextInt();
		int h2 = sc.nextInt();
		int w2 = sc.nextInt();
		
		if (h1 == h2 || w1 == w2 || h1 == w2 || h2 == w1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	private static void solveC() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		long res = 0;
		LinkedList<Integer> stack = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (stack.isEmpty()) {
				stack.push(num);
			} else {
				if (num > stack.peek()) {
					stack.push(num);
				} else {
					while (!stack.isEmpty()) {
						stack.pop();
					}
					stack.push(num);
				}
			}
			res += stack.size();
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
