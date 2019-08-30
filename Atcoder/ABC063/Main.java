
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  final static int MOD = 10007;

  public static void main(String[] args) {
    solveA();
    solveB();
    solveC();
    solveD();
  }
  

  private static void solveA() {
    FastReader sc = new FastReader();
    int a = sc.nextInt();
    int b = sc.nextInt();
    
    if (a + b >= 10) {
        System.out.println("error");
    } else {
      System.out.println(a + b);
    }
  }

  private static void solveB() {
    String s = sc.next();
    int[] charCnt = new int[26];
    
    for (char c: s.toCharArray()) {
      if (charCnt[c - 'a'] != 0) {
          System.out.println("no");
            System.exit(0);
        }
        charCnt[c - 'a']++;
    }
    System.out.println("yes");
  }

  private static void solveC() {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int res = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    // 先算全部共有幾分，如果分數總和不能被10整除，那總和就是答案。
    // 但分數總和可以被10整除，那就從所有題目當中找一題不能被10整除的問題出來做錯，
    // 那分數就不會被10整除，因為要最大分數，所以要做錯的那一題就是不能被10整除的
    // 數當中最小的那一個。
    // 如果所有問題的配分都是10的倍數，那一定顯示為0
    // すべての点数ぼの合計をSとする。
    // Sが１０の倍数である場合、０でない点数を表示させるためには一問以上の問題で不正解する必要がある。
    // もし点数が１０の倍数でないような問題が一問以上存在するなら、最も低い問題を引くは正解。
    // もしすべての問題の点数が１０の倍数、答えは０です。
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      res += num;
      if (num % 10 != 0) {
        pq.offer(num);
      }
    }
    
    if (res % 10 == 0) {
      if (pq.size() != 0) {
        res -= pq.poll();
      } else {
        res = 0;
      }
    }
    System.out.println(res);
  }

  private static void solveD() {
    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int[] hps = new int[n];
    int maxHp = 0;
    
    for (int i = 0; i < n; i++) {
      int hp = sc.nextInt();
      hps[i] = hp;
      maxHp = Math.max(maxHp, hp);
    }
    
    long left = 0;
    long right = (maxHp / b);
    while (left <= right) {
      long middle = (left + right ) / 2;
      if (isEnough(middle, hps, a, b)) {
        // 在middle回以內的爆炸可以消掉怪獸，因此找更小的
        // middle回以内の爆発で　全ての怪獣を消すことができる。
        // もっと　小さいmiddleを求める。
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    System.out.println(left);
  }

  // 可以在t回內打死所有怪獸嗎？
  // t回以内の爆発で　全ての怪獣を消すことができるか?
  private static boolean isEnough(long t, int[] hps, int a, int b) {
    long times = 0;
    for (int hp: hps) {
      if (hp > b*t) {
        times += (int)Math.ceil((hp*1.0 - b*t) / (double)(a - b));
      }
    }
    return times > t;
  }

  private static void tleD() {
    // 每次爆炸都打體力最多的怪獸，如此反覆到結束。
    // 但只要場上有幾隻１０＾９的怪獸就來不及了。
    // 残りの体力が一番多いの怪獣を中心に爆発を起こすことを繰り返すのはいい策略であるけど
    // 何匹体力１０＾９HPの怪獣がいれば　間に合わない
    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int[] hps = new int[n];
    int res = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    for (int i = 0; i < n; i++) {
      int hp = sc.nextInt();
      hps[i] = hp;
      pq.offer(hp);
    }
    
    while (!pq.isEmpty()) {
      int maxHp = pq.poll();
      maxHp -= a;
      
      if (!pq.isEmpty()) {
        int[] remainHp = new int[pq.size()];
        int pos = 0;
        while (!pq.isEmpty()) {
          remainHp[pos] = (pq.poll() - b);
          pos++;
        }
        
        for (int h: remainHp) {
          if (h > 0) {
            pq.offer(h);
          }
        }
      }
      
      if (maxHp > 0) { pq.offer(maxHp); }
      res++;
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
