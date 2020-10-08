package Question38;

import java.util.Scanner;

// https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String string = sc.nextLine();
			String[] strings = permutation(string);
			for(String str : strings) {
				System.out.println(str);
			}
		}
		sc.close();
	}
	
	public static String[] permutation(String s) {
		int A = 1;
		for(int i = 1; i <- s.length(); i++) {
			A *= i;
		}
		String[] strings = new String[A];
		for(int i = 0; i < A; i++) {
			
		}
		return strings;
    }
}
