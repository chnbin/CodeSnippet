
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
  }
  

  private static void solveA() {
    FastReader sc = new FastReader();int x = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();

    int A = Math.abs(x - a);
    int B = Math.abs(x - b);
  
    if (A < B) {
    	System.out.println("A");
    } else {
        System.out.println("B");
    }
  }

  private static void solveB() {
    FastReader sc = new FastReader();
    String s = sc.next();
    int[] charCnt = new int[26];
 
    for (char c: s.toCharArray()) {
      charCnt[c - 'a']++;
    }

    for (int i = 0; i < 26; i++) {
      if (charCnt[i] == 0) {
        System.out.println((char)(i + 'a'));
        System.exit(0);
      }
    }

    System.out.println("None");
    System.exit(0);
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    Map<Long, Long> map = new TreeMap<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			long l = sc.nextLong();
			map.put(l, map.getOrDefault(l, 0L) + 1L);
		}
	 
		long firstEdge = 0;
		long secondEdge = 0;
		int k = 2;
		for (long key: map.keySet()) {
			long cnt = map.get(key);
			
			// 如果有邊已經被取到，即使遇到正方形也不能取
			if (cnt >= 4 && k == 2) {
				System.out.println(key * key);
				System.exit(0);
			}
			
			if (cnt >= 2) {
				if (k == 2) {
					firstEdge = key;
					k--;
				} else if (k == 1) {
					secondEdge = key;
					k--;
				}
			}
			
			if (k == 0) {
				System.out.println(firstEdge * secondEdge);
				System.exit(0);
			}
		}
		System.out.println(0);
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
