package Question17;

// https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/

import java.util.Scanner;

public class Solution_v2 {
	static StringBuilder str = new StringBuilder();
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			printBigNumbers(n);
		}
		scanner.close();
	}

	public static void printBigNumbers(int n) {
		char[] result = new char[n];
	    recur(result, n, 0);
	}
		
	public static void recur(char[] result, int n, int index) {
	    if(index == n) {
	        removeZeroPrinter(result);
	        return;
	    }
	    for(int i = 0; i < 10; i++) {
	        result[index] = (char) ('0' + i);
	        recur(result, n, index + 1);
	    }
	}
	
	public static void removeZeroPrinter(char[] chars) {
	    boolean startPrint = false;
	    for(char c : chars) {
	        if(c != '0' && !startPrint) startPrint = true;
	        if(startPrint) System.out.print(c);
	    }
	    if(startPrint) System.out.print(" ");
	}
}
