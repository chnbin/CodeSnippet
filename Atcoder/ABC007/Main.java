
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	// AtCoder Beginner Contest 007
	// https://atcoder.jp/contests/abc007/tasks
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		String str = sc.next();
		if (str.length() > 1) {
			System.out.println(str.substring(0, str.length()-1));
			System.exit(0);
		} else {
			if (!str.equals("a")) {
				char c = str.charAt(0);
				System.out.println((char)(c - 1));
				System.exit(0);
			}
		}
		System.out.println(-1);
	}
	
	public static void a() {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		System.out.println(n-1);
	}
	
	public static void b() {
		FastReader sc = new FastReader();
		String str = sc.next();
		if (str.length() > 1) {
			System.out.println(str.substring(0, str.length()-1));
			System.exit(0);
		} else {
			if (!str.equals("a")) {
				char c = str.charAt(0);
				System.out.println((char)(c - 1));
				System.exit(0);
			}
		}
		System.out.println(-1);
	}
	
	public static void c() {
		FastReader sc = new FastReader();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[] start = new int[2];
		int[] goal = new int[2];
		int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		start[0] = sc.nextInt() - 1;
		start[1] = sc.nextInt() - 1;
		goal[0] = sc.nextInt() - 1;
		goal[1] = sc.nextInt() - 1;
		
		char[][] map = new char[r][c];
		
		for (int i = 0; i < r; i++) {
			String str = sc.next();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		Set<String> visited = new HashSet<>();
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		int res = -1;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			res++;
			
			for (int i = 0; i < size; i++) {
				int[] pos = queue.poll();
				if (pos[0] == goal[0] && pos[1] == goal[1]) {
					System.out.println(res);
					System.exit(0);
				}
				for (int[] dir: directions) {
					int dx = pos[0] + dir[0];
					int dy = pos[1] + dir[1];
					
					if (((0 <= dx) && (0 < r)) && ((0 <= dy) && (dy < c))) {
						if (!visited.contains(dx + "-" + dy) && map[dx][dy] == '.') {
							visited.add(dx + "-" + dy);
							int[] point = {dx, dy};
							queue.offer(point);
						}
					}
				}
			}
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
