### 面试题3：数组中重复的数字

#### 题目一：找出数组中重复的数字。

链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

- 思路1：先排序，再遍历
  - 时间复杂度O(nlogn)+O(n)
- 思路2：哈希表
  - 时间复杂度O(n)
  - 空间复杂度O(n)
- 思路3：比较nums[i]与i
  - 时间复杂度O(n)：每个数字最多被交换两次，从j到i，从i到nums[i]

##### 思路3

- 两层循环：外层遍历数组，内层遍历nums[i]与nums[nums[i]]关系

- 边界条件：
  - 数组为空或数组长度为0（如果默认return -1的话不用考虑）
    - 测试用例：`int[] nums = null;` `int[] nums = new int[0];`
    - [Java中数组为空和数组长度为0的区别](https://blog.csdn.net/u012156116/article/details/79690277)
  - 数组中有数字小于0或大于n-1
    - 测试用例：`int[] nums = { 2, -3, 1, 0, 2, 88, 3 };`