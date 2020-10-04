package Question58;

import java.util.Scanner;

// https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/

public class Part2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.nextLine();
			int i = scanner.nextInt();
			System.out.println(reverseLeftWords(string, i));
		}
		scanner.close();
	}
	
	public static String reverseLeftWords(String s, int n) {
		String stringLeft = reverse((s.substring(0, n)));
		String stringRight = reverse((s.substring(n)));
		return reverse(stringLeft + stringRight);
	}

	public static String reverse(String s) {
		if (s == "") {
			return "";
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			stringBuilder.append(s.charAt(i));
		}
		return stringBuilder.toString();
	}
}
