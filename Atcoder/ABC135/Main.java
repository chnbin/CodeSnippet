
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// AtCoder Beginner Contest 135
	// https://atcoder.jp/contests/abc135/tasks
	static long n;
	static int count = 0;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		n = sc.nextLong();
		System.out.println(count);
	}

	private static void a() {
		FastReader sc = new FastReader();
		int m = sc.nextInt();
		int n = sc.nextInt();
		String res = "IMPOSSIBLE";
		if (m > n) {
			int tmp = m;
			m = n;
			n = tmp;
		}
		
		for (int i = m; i < n; i++) {
			if (Math.abs(m - i) == Math.abs(n - i)) {
				res = "" + i;
			}
		}
		
		System.out.println(res);
	}
	
	private static void b() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		String res = "YES";
		int[] nums = new int[n];
		int[] sortedNums = new int[n];
		
		for (int i = 0; i < n; i++) {
			int p = sc.nextInt();
			nums[i] = p;
			sortedNums[i] = p;
		}
		
		Arrays.sort(sortedNums);
		
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			if (nums[i] != sortedNums[i]) {
				cnt++;
			}
		}
		
		if (cnt > 2) { res = "NO"; };
		
		System.out.println(res);
	}
	
	private static void c() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		long res = 0;
		long[] streets = new long[n+1];
		long[] heroes = new long[n];
		
		for (int i = 0; i < (n + 1); i++) {
			long monster = sc.nextInt();
			streets[i] = monster;
		}
		
		for (int i = 0; i < n; i++) {
			long damage = sc.nextInt();
			heroes[i] = damage;
		}
		
		long left = 0;
		
		for (int i = 0; i < n; i++) {
			long damage = heroes[i];
			long monster = streets[i];
			if (monster > 0) {
				res += left;
				monster -= left;
			}
			
			if (damage >= monster) {
				res += monster;
				left = Math.min(damage-monster, streets[i+1]);
			} else {
				res += Math.min(damage, monster);;
				left = 0;
			}
		}
		
		if (left > 0 && streets[streets.length - 1] > 0) {
			res += left;
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
