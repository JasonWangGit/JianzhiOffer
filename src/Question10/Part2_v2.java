package Question10;

import java.util.Scanner;

// https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/

public class Part2_v2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			System.out.println(numWays(n));
		}
		scanner.close();
	}
	
	public static int numWays(int n) {
		if(n < 0)
			return -1;
		if(n <= 1)
			return 1;
		int fib_0 = 1;
		int fib_1 = 1;
		int fib_n = 0;
		for(int i = 2; i <= n; i++) {
			fib_n = (fib_0 + fib_1) % 1000000007;
			fib_0 = fib_1;
			fib_1 = fib_n;
		}
		return fib_n;
    }
}
