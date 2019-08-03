
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// AtCoder Beginner Contest 107
	// https://atcoder.jp/contests/abc107/tasks
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int i = sc.nextInt();
		
		System.out.println(n - i + 1);
	}
	
	private void a() {
		FastReader sc = new FastReader();
		String str = sc.next();
		char[] c = str.toCharArray();
		Arrays.sort(c);

		if (c[0] == c[1] && c[2] == c[3] && c[0] != c[3]) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
	
	private void b() {
		FastReader sc = new FastReader();
      	int n = sc.nextInt();
      	int[] nums = new int[n];
      	for (int i = 0; i < n; i++) {
        	nums[i] = sc.nextInt();
        }
    	
      	int res = 0;
      	
    	for (int i = 1; i < nums.length - 1; i++) {
        	if (((nums[i-1] < nums[i]) && (nums[i] < nums[i+1])) || ((nums[i-1] > nums[i]) && (nums[i] > nums[i+1])))
        		res++;
        }
      	
      	System.out.println(res);
	}
	
	private void c() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] candies = new int[n];
		int res = Integer.MAX_VALUE;
 		for (int i = 0; i < n; i++) {
 			candies[i] = sc.nextInt();
		}
 		
 		for (int i = 0; i < n - k + 1; i++) {
 			int left = Math.abs(candies[i]) + (candies[i + k - 1] - candies[i]);
 			int right = Math.abs(candies[i + k - 1]) + (candies[i + k - 1] - candies[i]);
 			int tmp = Math.min(left, right);
 			res = Math.min(res, tmp);
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
