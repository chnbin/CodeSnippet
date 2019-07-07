import java.util.Scanner;

public class Main {

	private static final int k = 2019;
	public static void main(String[] args) {
		// https://atcoder.jp/contests/abc133/tasks
		a();
		b();
		c();
	}

	private static void a() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
      	int t1 = sc.nextInt();
      	int t2 = sc.nextInt();
      
      	if (n*t1 >= t2) {
          System.out.println(t2);
        } else {
          System.out.println(n*t1);
        }
		
		sc.close();
	}

	private static void b() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int d = sc.nextInt();
		int[][] points = new int[n][d];
		int res = 0;
		
		for (int i = 0; i < n; i++) {
			int[] point = new int[d];
			for (int j = 0; j < d; j++) {
				point[j] = sc.nextInt();
			}
			points[i] = point;
		}
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = i+1; j < n;j++) {
				double sum = 0.0;
				for (int k = 0; k < d; k++) {
					sum += (points[i][k] - points[j][k])*(points[i][k] - points[j][k]);
				}
				sum = Math.sqrt(sum);
				if ((sum - (int)sum) == 0) {res++;}
			}
		}
		
		System.out.println(res);
		
		sc.close();
	}
	
	private static void c() {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
      	int R = sc.nextInt();
      	
      	if (L == 0) {
      		System.out.println(0);
      		sc.close();
      		return ;
      	}
      	
      	if (R - L > 2018) {
      		System.out.println(0);
      		sc.close();
      		return;
      	}
      	
      	int res = Integer.MAX_VALUE;
      	L = L % k;
      	R = R % k;
      	
      	if (L > R) {
      		System.out.println(0);
      		sc.close();
      		return;
      	}
      	
        for (int i = L; i <= (R-1); i++) {
      		for (int j = i+1; j <= R; j++) {
      			int candidate = (i%k)*(j%k)%k;
      			res = Math.min(res, candidate);
      		}
        }
      	
      	System.out.println(res);
		sc.close();
	}
}
