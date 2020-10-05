package Question10;

import java.util.Scanner;

// https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/

public class Part2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int i = scanner.nextInt();
			System.out.println(fib(i));
		}
		scanner.close();
	}

	public static int numWays(int n) {
		if(n == 0) {
			return 1;
		}
		if (n < 3) {
			return n;
		}
		int fib_1 = 1;
		int fib_2 = 2;
		int fib = 0;
		for (int i = 3; i <= n; i++) {
			fib = fib_1 + fib_2;
			fib %= 1000000007;
			fib_1 = fib_2;
			fib_2 = fib;
		}
		return fib;
	}
}
