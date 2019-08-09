import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		
	}
	
	private static void solveA() {
		FastReader sc = new FastReader();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int res = 0;
		
		if (b % a == 0) {
			res = b / a;
		} else {
			res = (b / a) + 1;
		}
		
		System.out.println(res);
	}
	
	private static void solveB() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		char[][] m = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++) { 
				m[i][j] = s.charAt(j);
			}
		}
		
		int left = 0;
		int right = n - 1;
		
		while (left < right) {
			char[] tmp = m[left];
			m[left] = m[right];
			m[right] = tmp;
			left++;
			right--;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				char tmp = m[i][j];
				m[i][j] = m[j][i];
				m[j][i] = tmp;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println("");
		}
	}
	
	private static void solveC() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int[] nums = new int[n];
		int[] sorted = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			nums[i] = num;
			sorted[i] = num;
		}
		Arrays.sort(sorted);
		int prev = sorted[0];
		int order = 0;
		map.put(prev, order);
		for (int i = 1; i < n; i++) {
			if (sorted[i] != prev) {
				prev = sorted[i];
				order++;
				map.put(prev, order);
			}
		}
		
		for (int num: nums) {
			System.out.println(map.get(num));
		}
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
