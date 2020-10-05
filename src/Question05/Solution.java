package Question05;

import java.util.Scanner;

// https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.nextLine();
			System.out.println(replaceSpace(string));
		}
		scanner.close();
	}
	
	public static String replaceSpace(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				stringBuilder.append("%20");
			} else {
				stringBuilder.append(s.charAt(i));
			}
		}
		return stringBuilder.toString();
    }
	
	public static String replaceSpace2(String s) {
		return s.replaceAll(" ", "%20");
    }
	
}
