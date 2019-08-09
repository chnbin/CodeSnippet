import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		String s = sc.next();
		int[] charsCnt = new int[6];
		
		for (char c: s.toCharArray()) {
			charsCnt[c - 'A']++;
		}
		
		for (int i = 0; i < charsCnt.length; i++) {
			if (i != charsCnt.length - 1) {
				System.out.print(charsCnt[i] + " ");
			} else {
				System.out.println(charsCnt[i]);
			}
		}
	}
	
	private static void solveA() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		String res = "";
		
		if (n == 100) {
			res = "Perfect";
		} else if (n >= 90 && n <= 99) {
			res = "Great";
		} else if (n >= 60 && n <= 89) {
			res = "Good";
		} else {
			res = "Bad";
		}
		
		System.out.println(res);
	}
	
	private static void solveB() {
		FastReader sc = new FastReader();
		String s = sc.next();
		int[] charsCnt = new int[6];
		
		for (char c: s.toCharArray()) {
			charsCnt[c - 'A']++;
		}
		
		for (int i = 0; i < charsCnt.length; i++) {
			if (i != charsCnt.length - 1) {
				System.out.print(charsCnt[i] + " ");
			} else {
				System.out.println(charsCnt[i]);
			}
		}
	}
	
	private static void solveC() {
		FastReader sc = new FastReader();
		int[] nums = new int[5];
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;
		
		for (int i = 0; i < 5; i++) {
			nums[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = i + 1; j < 4; j++) {
				for (int k = j + 1; k < 5; k++) {
					int total = nums[i] + nums[j] + nums[k];
					
					if (total > first) {
						third = second;
						second = first;
						first = total;
					} else if (total > second) {
						third = second;
						second = total;
					} else if (total > third) {
						third = total;
					}
				}
			}
		}
		
		System.out.println(third);
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
