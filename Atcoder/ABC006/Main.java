import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// AtCoder Beginner Contest 006
	// https://atcoder.jp/contests/abc006/tasks
	final static int MOD = 10007;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		
		if (n == 1 || n == 2) {
			System.out.println("0");
			System.exit(0);
		}
		
		int[] dp = new int[n];
		dp[2] = 1;
		
		for (int i = 3; i < n; i++) {
			dp[i] = (dp[i - 3] % MOD + dp[i - 2] % MOD + dp[i - 1] % MOD) % MOD;
		}
		System.out.println(dp[n-1]);
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
		int n = sc.nextInt();
		
		if (n == 1 || n == 2) {
			System.out.println("0");
			System.exit(0);
		}
		
		int[] dp = new int[n];
		dp[2] = 1;
		
		for (int i = 3; i < n; i++) {
			dp[i] = (dp[i - 3] % MOD + dp[i - 2] % MOD + dp[i - 1] % MOD) % MOD;
		}
		System.out.println(dp[n-1]);
	}
	
	private static void d() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int[] nums = new int[n];
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		
		// To find L.I.S
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int lengthOfLIS = 0;
		
		for (int i = 0; i < n; i++) {
			lengthOfLIS = Math.max(lengthOfLIS, dp[i]);
		}
		
		System.out.println(n - lengthOfLIS);
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
