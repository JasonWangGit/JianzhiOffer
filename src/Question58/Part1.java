package Question58;

import java.util.Scanner;

// https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/

public class Part1 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.nextLine();
			System.out.println(reverseWords(string));
		}
		scanner.close();
	}

	public static String reverseWords(String s) {
		StringBuilder stringBuilderResult = new StringBuilder();
		StringBuilder stringBuilderTemp = new StringBuilder();
		String stringTemp = reverse(removeSpace(s));
		for (int i = 0; i < stringTemp.length(); i++) {
			if (stringTemp.charAt(i) == ' ') {
				stringBuilderResult.append(reverse(stringBuilderTemp.toString()));
				stringBuilderResult.append(' ');
				stringBuilderTemp.setLength(0);
				;
			} else {
				stringBuilderTemp.append(stringTemp.charAt(i));
			}
		}
		stringBuilderResult.append(reverse(stringBuilderTemp.toString()));
		return stringBuilderResult.toString();
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
	
	public static String removeSpace(String s) {
		if (s == "") {
			return "";
		}
		s = s.trim();
		StringBuilder stringBuilder = new StringBuilder();
		boolean spaceFlag = false;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != ' ') {
				if(spaceFlag) {
					stringBuilder.append(' ');
					spaceFlag = false;
				}
				stringBuilder.append(s.charAt(i));
			} else {
				spaceFlag = true;
			}
		}
		return stringBuilder.toString();
	}
}
