package Question10;

import java.util.Scanner;

// https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/

public class Part1 {
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
	
	public static int fib(int n) {
		if(n < 2) {
			return n;
		}
		int fib_0 = 0;
		int fib_1 = 1;
		int fib = 0;
		for(int i = 2; i <=n; i++) {
			fib = fib_0 + fib_1;
			fib %= 1000000007;
			fib_0 = fib_1;
			fib_1 = fib;
		}
		return fib;
    }
}
