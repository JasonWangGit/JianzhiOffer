package Question17;

// https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/

import java.util.Scanner;

public class Solution {
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
	
	public static int[] printNumbers(int n) {
		int max = 1;
		while(n > 0) {
			max *= 10;
			n--;
		}
		int[] array = new int[max - 1];
		for(int i = 0; i < max - 1; i++)
			array[i] = i + 1;
		return array;
    }

	public static void printBigNumbers(int n) {
		if(n <= 0)
			return;
		char[] chars = new char[n];
		recur(chars, n, 0);
	}
	
	public static void recur(char[] chars, int n, int index) {
		if(index == n) {
			removeZeroPrinter(chars);
			return;
		}
		for(int i = 0; i < 10; i++) {
			chars[index] = (char) ('0' + i);
			recur(chars, n, index + 1);
		}
	}
	
	public static void removeZeroPrinter(char[] chars) {
		int index = 0;
		boolean firstFlag = true;
		while(true) {
			if(index == chars.length) {
				System.out.print("");
				firstFlag = false;
				break;
			}
			if(chars[index] != '0')
				break;
			index++;
		}
		while(index < chars.length)
			System.out.print(chars[index++]);
		if(firstFlag)
			System.out.print(" ");
	}
}
