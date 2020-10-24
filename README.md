### 面试题3：数组中重复的数字

#### [题目一：找出数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof)

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

##### 边界条件：
- 数组为空或数组长度为0（如果默认return -1的话不用考虑）
  - 测试用例：`int[] nums = null;` `int[] nums = new int[0];`
  - [Java中数组为空和数组长度为0的区别](https://blog.csdn.net/u012156116/article/details/79690277)
- 数组中有数字小于0或大于n-1
  - 测试用例：`int[] nums = { 2, -3, 1, 0, 2, 88, 3 };`

### 面试题4：二维数组中的查找

#### [题目](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof)

在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

- 思路1：从右上角入手

##### 思路1

- 一层循环：从右上角开始

  - 如果target大于当前数，j--
  - 如果target小于当前数，i++

##### 边界条件：

- 矩阵为空或矩阵长度等于0
  - 测试用例：`int[][] matrix = null;` `int[][] matrix = new int[0][0];`
- 矩阵中只有一个数字
  - 测试用例：`int[][] matrix = {{5}};`

### 面试题5 替换空格

#### [题目](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

请实现一个函数，把字符串 s中的每个空格替换成"%20"。

- 思路1：遍历并利用StringBuilder
- 思路2：利用.replaceAll

##### 边界条件：
- 字符串为空
  - 测试用例：`String s = null;`

### 面试题6 从尾到头打印链表

#### [题目](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

- 思路1：利用辅助栈
- 思路2：利用递归

##### 边界条件：
- 链表为空（实际上，由于while循环的条件，不用考虑）
  - 测试用例：`ListNode head = null;`