### 面试题3：数组中重复的数字

#### [题目一：找出数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof)

在一个长度为 n 的数组里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。

- 思路1：先排序，再遍历
  - 时间复杂度O(nlogn)+O(n)
- 思路2：哈希表
  - 时间复杂度O(n)
  - 空间复杂度O(n)
- 思路3：比较nums[i]与i
  - 时间复杂度O(n)：每个数字最多被交换两次，从j到i，从i到nums[i]

##### 思路3

- 两层循环：外层遍历数组，内层遍历nums[i]与nums[nums[i]]关系

##### 特殊输入

- 数组为空或数组长度为0（如果默认return -1的话不用考虑）
  - 测试用例：`int[] nums = null;` `int[] nums = new int[0];`
  - [Java中数组为空和数组长度为0的区别](https://blog.csdn.net/u012156116/article/details/79690277)
- 数组中有数字小于0或大于n-1
  - 测试用例：`int[] nums = { 2, -3, 1, 0, 2, 88, 3 };`

##### 核心代码

```java
	public static int findRepeatNumber(int[] nums) {
		if(nums == null)
			return -1;
		for(int i : nums)
			if(i < 0 || i >= nums.length)
				return -1;
		for(int i = 0; i < nums.length; i++) {
			while(nums[i] != i) {
				if(nums[i] != nums[nums[i]])
					QuickSort.swap(nums, nums[i], i);
				else
					return nums[i];
			}
		}
		return -1;
	}
```



### 面试题4：二维数组中的查找

#### [题目](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof)

在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

- 思路1：从右上角入手

##### 思路1

- 一层循环：从右上角开始
  - 如果target大于当前数，i++
  - 如果target小于当前数，j--

##### 特殊输入

- 矩阵为空或矩阵长度等于0
  - 测试用例：`int[][] matrix = null;` `int[][] matrix = new int[0][0];`
- 矩阵中只有一个数字
  - 测试用例：`int[][] matrix = {{5}};`

##### 核心代码

```java
	public static boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix == null)
			return false;
		if(matrix.length == 0)
			return false;
		int i = 0;
		int j = matrix[0].length - 1;
		while(i < matrix.length && j >= 0) {
			if(target > matrix[i][j])
				i++;
			else if(target < matrix[i][j])
				j--;
			else {
				return true;
			}
		}
		return false;
	}
```



### 面试题5 替换空格

#### [题目](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

请实现一个函数，把字符串中的每个空格替换成"%20"。例如，输入"We are happy."，则输出"We%20are%20happy."。

- 思路1：遍历并利用StringBuilder
- 思路2：利用.replaceAll

##### 特殊输入

- 字符串为空
  - 测试用例：`String s = null;`

核心代码：

```java
	public static String replaceSpace(String s) {
		if(s == null)
			return null;
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ')
				stringBuilder.append("%20");
			else
				stringBuilder.append(s.charAt(i));
		}
		return stringBuilder.toString();
	}

	public static String replaceSpaceByReplaceAll(String s) {
		return s.replaceAll(" ", "%20");
	}
```



### 面试题6 从尾到头打印链表

#### [题目](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

- 思路1：利用辅助栈
- 思路2：利用递归

##### 特殊输入

- 链表为空（实际上，由于while循环的条件，不用考虑）
  - 测试用例：`ListNode head = null;`

##### 核心代码

```java
	public static int[] reversePrintByStack(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while(head != null) {
			stack.push(head.val);
			i++;
			head = head.next;
		}
		int[] nums = new int[i];
		i = 0;
		while(!stack.isEmpty())
			nums[i++] = stack.pop();
		return nums;
	}
	
	public static void reversePrintByRecur(ListNode head) {
		if(head == null)
			return;
		reversePrintByRecur(head.next);
		System.out.print(head.val + " ");
	}
```



### 面试题7 重建二叉树

#### [题目](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如，输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建如图2.6所示的二叉树并输出它的头节点。

- 思路1：递归实现：先前序找根，后中序找左右子树

##### 思路1

- 递归参数：
  - 两个数组：前序遍历、中序遍历
  - 前序遍历的当前左、右端
  - 中序遍历的当前左、右端 
- 边界条件：
  - 在中序遍历数组中根的位置等于当前左端 -> 无左子树
  - 在中序遍历数组中根的位置等于当前右端 -> 无右子树
- 前进段：
  - 左子树情况：
    - 前序遍历数组左端为当前左端+1
    - 前序遍历数组右端为当前左端+左子树长度
    - 中序遍历数组左端为当前左端
    - 中序遍历数组右端为当前根位置-1
  - 右子树情况：
    - 前序遍历数组左端为当前左端+1+左子树长度
    - 前序遍历数组右端为当前右端
    - 中序遍历数组左端为当前根位置+1
    - 中序遍历数组右端为当前右端
- 返回段：
  - 返回当前的根

##### 特殊输入

- 数组之一为空
  - 测试用例：`int[] preorder = null;` `int[] inorder = null;`
- 数组之一的长度为0
  - 测试用例：`int[] preorder = new int[0];` `int[] inorder = new int[0];`
- 两个数组长度不相等
  - 测试用例： `int[] preorder = {3, 9, 20, 15, 7};` `int[] inorder = {9, 3, 15};`

##### 核心代码

```java
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length)
			return null;
		return recur(preorder, inorder, 
				0, preorder.length - 1, 0, inorder.length - 1);
	}
	
	public static TreeNode recur(int[] preorder, int[] inorder, 
			int preLeft, int preRight, int inLeft, int inRight) {
		TreeNode root = new TreeNode(preorder[preLeft]);
		int rootPos = 0;
		for(int i = inLeft; i <= inRight; i++)
			if(inorder[i] == preorder[preLeft]) {
				rootPos = i;
				break;
			}
		int leftLength = rootPos - inLeft;
		if(rootPos == inLeft)
			root.left = null;
		else
			root.left  = recur(preorder, inorder, preLeft + 1, preLeft + leftLength, inLeft, rootPos - 1);
		if(rootPos == inRight)
			root.right = null;
		else
 			root.right = recur(preorder, inorder, preLeft + leftLength + 1, preRight, rootPos + 1, inRight);
		return root;
	}
```



### 面试题8 二叉树的下一个节点

#### 题目

给定一颗二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？树中的节点除了有两个分别指向左右子节点的指针，还有一个指向父节点的指针。

- 思路1：分三类考虑

##### 思路1

- 情况1：如果一个节点有右子树，那么它的下一个节点就是它的右子树中最左子节点
- 情况2 & 3：如果一个节点没有右子树
  - 情况2：如果节点是它父节点的左子节点，那么它的下一个节点就是它的父节点
  - 情况3：如果节点是它父节点的右子节点，那么
    - 沿着指向父节点的指针一直向上遍历，直到找到一个是它父节点的左子节点的节点
      - 如果知道根节点都没找到，那它就是最后一个节点，没有下一个节点

##### 特殊输入

- 树（根节点）为空
  - 测试用例：`TreeNode root = null `
- 指定节点为空
  - 测试用例：`TreeNode node = null `

##### 核心代码

```java
	public static TreeNode findNext(TreeNode root, TreeNode treeNode) {
		if(root == null || treeNode == null)
			return null;
		if(treeNode.right != null) {
			TreeNode temp = treeNode.right;
			while(temp.left != null)
				temp = temp.left;
			return temp;
		} else if(treeNode == treeNode.parent.left)
			return treeNode.parent;
		else {
			TreeNode temp = treeNode.parent;
			while(temp != temp.parent.left)
			{
				temp = temp.parent;
				if(temp == root)
					return null;
			}
			return temp;
		}
	}
```



### 面试题9 用两个栈实现队列

#### [题目](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。

- 思路1：分入队和出队考虑

##### 思路1

- 入队：无论何种情况，都压入到第一个栈
- 出队：无论何种情况，都从第二个栈弹出
  - 第二个栈不为空，直接弹出
  - 第二个栈为空
    - 第一个栈为空，返回-1（表示异常）
    - 第一个栈不为空，将第一个栈中元素全部压入第二个栈，然后弹出

##### 特殊输入

- 不入队情况下直接出队
- 出队次数大于入队次数

##### 核心代码

```java
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public CQueue_v2() {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}
    
	public void appendTail(int value) {
		stack1.push(value);
	}
    
	public int deleteHead() {
		if(stack2.isEmpty())
			if(stack1.isEmpty())
				return -1;
			else
				while(!stack1.isEmpty())
					stack2.push(stack1.pop());
		return stack2.pop();
	}
```

### 面试题10 斐波那契数列

#### [题目一：求斐波那契数列的第n项](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)

写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
$$
f(n) = \begin{cases}0&\text{n = 0}\\1&\text{n = 1}\\f(n-1)+f(n-2)&\text{n > 1}\end{cases}
$$

- 思路1：递归，从上（n）至下（1）求解
  - 问题在于会重复计算很多次
- 思路2：循环，从下（1）至上（n）求解

##### 特殊输入

- n小于0

##### 核心代码

```java
	public static int fibByRecur(int n) {
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		return fibByRecur(n - 1) + fibByRecur(n - 2);
	}
	
	public static int fibByLoop(int n) {
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		int fib_0 = 0;
		int fib_1 = 1;
		int fib_n = 0;
		for(int i = 2; i <= n; i++) {
			fib_n = (fib_0 + fib_1) % 1000000007;
			fib_0 = fib_1;
			fib_1 = fib_n;
		}
		return fib_n;
	}
```

#### [题目二：青蛙跳台阶问题](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。

- 思路1：同题目一
- 思路2：同题目二
- 这里需要注意的问题是：f(0)是1，f(1)是1，f(2)是2，这与题目一是有区别的，之后的规律不变

##### 特殊输入

- n小于0

##### 核心代码

```java
	public static int numWays(int n) {
		if(n < 0)
			return -1;
		if(n <= 1)
			return 1;
		int fib_0 = 1;
		int fib_1 = 1;
		int fib_n = 0;
		for(int i = 2; i <= n; i++) {
			fib_n = (fib_0 + fib_1) % 1000000007;
			fib_0 = fib_1;
			fib_1 = fib_n;
		}
		return fib_n;
	}
```

### 面试题11：旋转数组的最小数字

#### [题目](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为1。  

- 思路1：遍历
  - 时间复杂度O(n)
- 思路2：利用二分查找的原理
  - 时间复杂度O(logn)

##### 思路2

- x循环：利用left、right两个指针，不断缩小寻找的范围
- 循环结束条件：
  - left指针与right指针相邻，right指向的元素就是最小值

- 对于大多数情况的正常旋转数组
  - 如果middle大于等于left，则让left=middle
  - 如果middle小于等于right，则让right=middle
- 并未旋转的数组
  - 根据第一个元素与最后一个元素的大小判定，直接返回第一个元素作为最小值
- 特殊数组，如{1, 0, 1, 1, 1}
  - 如果出现left=middle=right，则只能遍历数组寻找最小值

##### 特殊输入

- 数组为空
  - 测试用例：`int[] numbers = null;`
- 数组长度为0
  - 测试用例：`int[] numbers = new int[0];`
- 数组并未旋转
  - 测试用例：`int[] numbers = {1, 2, 3, 4, 5};`
- 特殊数组
  - 测试用例：`int[] numbers = {1, 0, 1, 1, 1};` `int[] numbers = {2, 2, 2, 0, 1};`

##### 核心代码

```java
	public static int minArray(int[] numbers) {
		if (numbers[0] < numbers[numbers.length - 1])
			return numbers[0];
		int left = 0;
		int right = numbers.length - 1;
		int middle = 0;
		while (left != right - 1) {
			middle = (left + right) / 2;
			if (numbers[middle] == numbers[left] && numbers[middle] == numbers[right]) {
				int min = numbers[0];
				for (int i : numbers) {
					min = Math.min(min, i);
				}
				return min;
			}
			if (numbers[middle] >= numbers[left])
				left = middle;
			if (numbers[middle] <= numbers[right])
				right = middle;
		}
		return numbers[right];
	}
```

### 面试题12：矩阵中的路径

#### [题目](https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/)