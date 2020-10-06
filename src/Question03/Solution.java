package Question03;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		int[] array = {2, 3, 1, 0, 2, 5, 3};
		System.out.println(findRepeatNumber(array));
	}

	public static int findRepeatNumber(int[] nums) {
		Map<Integer, Boolean> map = new HashMap<>();
		int temp = 0;
		for(int i : nums) {
			if(!map.containsKey(i)) {
				map.put(i, false);
			} else {
				if(!map.get(i)) {
					map.replace(i, true);
					temp =  i;
					break;
				}
			}
		}
		return temp;
    }
}
