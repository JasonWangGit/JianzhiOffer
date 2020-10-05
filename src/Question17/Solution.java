package Question17;

import java.util.Scanner;

public class Solution {
	static StringBuilder str = new StringBuilder();
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int i = scanner.nextInt();
			func(i);
		}
		scanner.close();
	}
	
	public static void func(int n) {
		for(int i = 1; i <= 1 ; i++) {
			for(int j = 0; j <= 9; j++) {
				System.out.print(j + ",");
			}
		}
	}
	
	
	public static void print0_9()
	{
		
	}

	public static int[] printNumbers(int n) {
		int[] ints = {0,0,0};
		return ints;
	}
	
	public static void generateNumbers(int n) {
		if(n == 1) {
			for(int i = 0; i < 10; i++) {
				str.append(i);
				str.append(',');
			}
			return;
		} else {
			for(int i = 0; i < 10; i++) {
			}
		}
	}
}
