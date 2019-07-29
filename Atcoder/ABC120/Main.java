
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
	// AtCoder Beginner Contest 120
	// https://atcoder.jp/contests/abc120/tasks
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		String s = sc.next();
		LinkedList<Integer> stack = new LinkedList<>();
		int res = 0;
		int cnt0 = 0;
		int cnt1 = 0;
		
		for (char c: s.toCharArray()) {
			int code = c - '0';
			if (code == 0) {
				cnt0++;
			} else {
				cnt1++;
			}
		}
		
		System.out.println(2*Math.min(cnt0, cnt1));
	}
	
	private void a() {
		FastReader sc = new FastReader();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int n = Math.min(b / a, c);
		System.out.println(n);
	}
	
	private void b() {
		FastReader sc = new FastReader();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int k = sc.nextInt();
		int n = Math.min(a, b);
		int res = 0;
		
		for (int i = n; i >= 1; i--) {
			if (a%i == 0 && b%i == 0) {
				k--;
				res = i;
				if (k == 0) {
					break;
				}
			}
		}
		
		System.out.println(res);
	}
	
	private void c() {
		FastReader sc = new FastReader();
		String s = sc.next();
		LinkedList<Integer> stack = new LinkedList<>();
		int res = 0;
		
		for (char c: s.toCharArray()) {
			int code = c - '0';
			
			if (!stack.isEmpty() && (code ^ (stack.peek())) == 1) {
				stack.pop();
				res += 2;
			} else {
				stack.push(c-'0');
			}
		}
		
		System.out.println(res);
	}
	
	// A smarted method of task 3
	private void c2() {
		FastReader sc = new FastReader();
		String s = sc.next();
		LinkedList<Integer> stack = new LinkedList<>();
		int res = 0;
		int cnt0 = 0;
		int cnt1 = 0;
		
		for (char c: s.toCharArray()) {
			int code = c - '0';
			if (code == 0) {
				cnt0++;
			} else {
				cnt1++;
			}
		}
		
		System.out.println(2*Math.min(cnt0, cnt1));
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

class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}