import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// AtCoder Beginner Contest 136
	// https://atcoder.jp/contests/abc136/tasks
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int[] nums = new int[n];
		
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		
		int count = 1;
		
		for (int i = n - 1 ; i >= 1; i--) {    
			if (nums[i - 1] - 1 == nums[i] ) {
				nums[i-1]--;
				count++;
			} else if (nums[i - 1] <= nums[i]) {
				count++;
			} else {
				break;
			}
		}
		
		if (count == n) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
	
	private static void a() {
		FastReader sc = new FastReader();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if (b > a) { b = a; }
		if (c < (a - b)) {
			System.out.println("0");
		} else {
			System.out.println(c- (a -b));
		}
	}
	
	private static void b() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int res = 0;
		
		for (int i = 1 ; i <= n; i++) {
			if (String.valueOf(i).length() % 2 == 1) {
				res++;
			}
		}
		System.out.println(res);
	}
	
	private static void c() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int[] nums = new int[n];
		
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		
		int count = 1;
		
		for (int i = n - 1 ; i >= 1; i--) {    
			if (nums[i - 1] - 1 == nums[i] ) {
				nums[i-1]--;
				count++;
			} else if (nums[i - 1] <= nums[i]) {
				count++;
			} else {
				break;
			}
		}
		
		if (count == n) {
			System.out.println("Yes");
		} else {
			System.out.println("No");}	
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
