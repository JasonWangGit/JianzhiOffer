### 知识点

#### 递归

三要素：当边界条件不满足时，递归前进；当边界条件满足时，递归返回（**还要注意递归的参数**）

- 边界条件：控制递归的结束
- 递归前进段
- 递归返回段

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

- 字符串为空或字符串长度为0
  - 测试用例：`String s = null;` `String s = "";`

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

- 思路1：先前序找根，后中序找左右子树（递归实现）

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
- 没有左右子树的根节点（**下面代码未考虑**）
  - 测试用例：`TreeNode root = new TreeNode('a'); TreeNode node = root;`
- 只有左子树的根节点（**下面代码未考虑**）
  - 测试用例：`TreeNode root = new TreeNode('a'); root.left = new TreeNode('b'); TreeNode node = root;`

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
f(n) = \begin{cases} 0 & \text{n = 0} \\ 1 & \text{n = 1} \\ f(n-1)+f(n-2) & \text{n > 1} \end{cases}
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

- 循环：利用left、right两个指针，不断缩小寻找的范围
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
		if(numbers == null || numbers.length == 0)
			return -1;
		if(numbers[0] < numbers[numbers.length - 1])
			return numbers[0];
		int left = 0;
		int right = numbers.length - 1;
		int middle = 0;
		while(left != right - 1) {
			middle = (left + right) / 2;
			if(numbers[middle] == numbers[left] && numbers[middle] == numbers[right]) {
				int min = numbers[0];
				for(int i : numbers) {
					min = Math.min(min, i);
				}
				return min;
			}
			if(numbers[middle] >= numbers[left])
				left = middle;
			if(numbers[middle] <= numbers[right])
				right = middle;
		}
		return numbers[right];
	}
```

### 面试题12：矩阵中的路径

#### [题目](https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/)

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用下画线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
$$
\begin{matrix} a & \underline b & t & g \\ c & \underline f & \underline c & s \\ j & d & \underline e & h \end{matrix}
$$

- 思路1：回溯法（递归实现）

##### 思路1

- 递归参数：
  - 字符矩阵，判断是否访问过的矩阵，目标字符串
  - 当前访问到目标字符串的位置
  - 当前访问到字符矩阵的位置：行、列
- 边界条件：
  - 矩阵行、列越界：false
    - 行小于0或大于等于length-1
    - 列小于0或大于length-1
  - 字符矩阵当前行、列位置的值不等于目标字符串当前位置的值：false
  - 字符矩阵当前列、列位置已被访问：false
  - 当前访问到目标字符串的位置等于目标字符串的长度-1：true
- 前进段：
  - 注意前进前需将已访问置为true，前进后将已访问置为false
  - 向上
    - 行-1，列不动
  - 向下
    - 行+1，列不动
  - 向左
    - 行不动，列-1
  - 向右
    - 行不动，列+1
- 返回段：
  - 返回上、下、左、右四种情况的或

##### 特殊输入

- 目标字符串为空：true
  - 测试用例：`String word = null;` 
- 字符矩阵为空：false（这里这样写是基于先执行上一条判断，目标字符串不为空、字符矩阵为空，一定false）
  - 测试用例：`char[][] board = false;`
- 目标字符串长度为0：true
  - 测试用例： `String word = "";` 
- 字符矩阵长度为0：false（这里这样写是基于先执行上一条判断，目标字符串长度不为0、字符矩阵长度为0，一定false）
  - 测试用例：`char[][] board = new char[0][0];`

##### 核心代码

```java
	public static boolean exist(char[][] board, String word) {
		if(word == null)
			return true;
		if(board == null)
			return false;
		if(word.length() == 0)
			return true;
		if(board.length == 0)
			return false;
		if(word.length() > board.length * board[0].length)
			return false;
		boolean[][] isVisited = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[0].length; j++)
				if(recur(board, isVisited, word, 0, i, j))
					return true;
		return false;
	}
	
	public static boolean recur(char[][] board, boolean[][] isVisited, String word,
			int index, int i, int j) {
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return false;
		if(word.charAt(index) != board[i][j] || isVisited[i][j])
			return false;
		if(index == word.length() - 1)
			return true;
		isVisited[i][j] = true;
		index++;
		boolean flag = recur(board, isVisited, word, index, i - 1, j) ||
				recur(board, isVisited, word, index, i + 1, j) ||
				recur(board, isVisited, word, index, i, j - 1) ||
				recur(board, isVisited, word, index, i, j + 1);
		isVisited[i][j] = false;
		return flag;
	}
```

### 面试题13：机器人的运动范围

#### [题目](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

地上有一个m行n列的方格 。一个机器人从坐标 (0, 0) 的格子开始移动，它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的**数位之和**大于k的格子。例如，当k为18时，机器人能够进入方格 (35, 37) ，因为3+5+3+7=18。但它不能进入方格 (35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

- 思路1：回溯法（递归实现）

##### 思路1

- 递归参数：
  - 判断是否访问过的矩阵
  - k值
  - 当前访问到矩阵的位置：行、列
- 边界条件：
  - 矩阵行、列越界：0
    - 行小于0或大于等于length-1
    - 列小于0或大于length-1
  - 矩阵当前列、列位置已被访问：0
  - 矩阵当前列、列位置是不可进入的：0
  - 矩阵当前列、列位置是可进入的：1
- 前进段：
  - 注意前进前需将已访问置为true
  - 向上
    - 行-1，列不动
  - 向下
    - 行+1，列不动
  - 向左
    - 行不动，列-1
  - 向右
    - 行不动，列+1
- 返回段：
  - 返回上、下、左、右四种情况和当前位置（1）的和

##### 特殊输入

- m或n的值小于0

##### 核心代码

```java
	public static int movingCount(int m, int n, int k) {
		if(m < 0 || n < 0)
			return -1;
		boolean[][] isVisited = new boolean[m][n];
		return recur(isVisited, k, 0, 0);
	}
	
	public static int recur(boolean[][] isVisited, int k, int i, int j) {
		if(i < 0 || j < 0 || i >= isVisited.length || j >= isVisited[0].length)
			return 0;
		if(isVisited[i][j])
			return 0;
		isVisited[i][j] = true;
		if(isEnterable(k, i, j))
			return 1 + recur(isVisited, k, i - 1, j) + recur(isVisited, k, i + 1, j)
		+ recur(isVisited, k, i, j - 1) + recur(isVisited, k, i, j + 1);
		else
			return 0;

	}
	
	public static boolean isEnterable(int k, int i, int j) {
		int digitSum = 0;
		while(i != 0) {
			digitSum += i % 10;
			i /= 10;
		}
		while(j != 0) {
			digitSum += j % 10;
			j /= 10;
		}
		if(digitSum > k)
			return false;
		else
			return true;
	}
```

### 面试题14：剪绳子

#### [题目](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/)

给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0], k[1], ..., k[m] 。请问 k[0] × k[1] × ... × k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

- 思路1：动态规划，从下往上计算（避免重复计算）
- 思路2：贪婪

##### 思路1

- 首先，f(1)为0，f(2)为1（1*1），f(3)为2（2\*1），这是因为至少要剪1刀导致的

$$
f(n) = max(f(i) * f(n - i))
$$

- 对长度为n的绳子，最大乘积是剪一刀与另一刀最大值 的所有情况的最大值 ，而另一刀的最大值可能是由若干刀的乘积组成的，所以需要将长度为i时候的最大值存储在一个数组已供使用
- 根据这种规律从下往上计算，比如
  - f(4)有f(1)和f(3)、f(2)和f(2)两种情况，则取他们的最大值记录在一个数组里
    - 这里f(1)为1，f(2)为2，f(3)为3，这是因为已经剪过1刀了，注意和上面的不同

- 数组的最后一项就是f(n)

##### 思路2

- 可以发现当n >= 5时候，3 * (n - 3) 大于 2 * (n - 2) 和1 * (n - 1) 和n
- 所以应该尽可能多地剪长度为3的绳子
- 一直按长度为3去剪，如果最后剩余4，则取2 * 2
- 如果剩余长度小于4，则取对应长度即可
- **注意**：result用long的原因是result *= 3有可能会越界

##### 特殊输入

- 长度是负数
- 长度是0
- 长度是比较大的数

##### 核心代码

```java
	public static int cuttingRopeByDP(int n) {
		if(n < 0)
			return -1;
		if(n < 2)
			return 0;
		if(n == 2)
			return 1;
		if(n == 3)
			return 2;
		int[] maxArray = new int[n + 1];
		maxArray[1] = 1;
		maxArray[2] = 2;
		maxArray[3] = 3;
		int max;
		for(int i = 4; i <= n; i ++) {
			max = maxArray[i - 1] * maxArray[1];
			for(int j = 2; j <= i / 2; j++)
				max = Math.max(max, (maxArray[i - j]) * maxArray[j]);
			maxArray[i] = max;
		}
		return maxArray[n];
	}
	
	public static int cuttingRopeByGreedy(int n) {
		if(n < 0)
			return -1;
		if(n < 2)
			return 0;
		if(n == 2)
			return 1;
		if(n == 3)
			return 2;
		long result = 1l;
		while(n > 4) {
			n -= 3;
			result *= 3;
			result %= 1000000007;
		}
		if(n == 4) {
			result *= 4;
			result %= 1000000007;
		}
		else {
			result *= n;
			result %= 1000000007;
		}
		return (int) result;	
	}
```

### 面试题15：二进制种1的个数

#### [题目](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)

请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

- 思路1：利用Java中的左边补零右移（>>>）
- 思路2：利用n & n - 1：将n最右边的1变成0

##### 特殊输入

- n等于0

- n小于0

##### 核心代码

```java
	public static int hammingWeightByRightShift(int n) {
		int count = 0;
		while(n != 0) {
			if((n & 1) != 0)
				count++;
			n >>>= 1;
		}
		return count;
	}
	
	public static int hammingWeight(int n) {
		int count = 0;
		while(n != 0) {
			n &= n - 1;
			count++;
		}
		return count;
	}
```

### 面试题16：数值的整数次方

#### [题目](https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/)

实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

- 思路1：普通循环，乘n次
- 思路2：二分法，递归实现
- 思路3：二分法，循环实现

##### - 思路3

$$
a^n = \begin{cases} a^{n/2} \cdot a^{n/2} & \text{n为偶数} \\ a^{(n-1)/2} \cdot a^{(n-1)/2} \cdot a & \text{n为奇数} \end{cases}
$$

- 初始条件
  - n为0时
    - x为0：错误（异常）
    - x不为0：return 0
  - n大于0
  - n小于0
    - `n = -n;`
    - `x = 1 / x;`
- 循环体内
  - n为偶数时
    - `x *= x;` `n >>= 1;`
  - n为奇数时（`(n & 1) == 1`）
    - 除上述外，`result *= x;`

##### 核心代码

```java
	public static double myPowByLoop(double x, int n) {
		double result = 1;
		long p = n;
		if(p == 0 && isEqual(x, 0.0))
			return 0.0;
		if(p == 0 && !isEqual(x, 0.0))
			return 1.0;
		if(p < 0) {
			x = 1 / x;
			p = -p;
		}
		while(p > 0) {
			if((p & 1) == 1)
				result *= x;
			x *= x;
			p >>= 1;
		}
		return result;
	}
```

### 面试题17：打印从1到最大的n位数

#### [题目](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)

输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

- 思路1：计算出n位数最大值，然后从1开始循环输出（不适用于大数）
- 思路2：对一个长度为n的字符数组，通过递归进行全排列（适用于大数，但大数递归层级过深）

##### 思路2

- 递归参数：
  - 字符数组
  - n值
  - index：当前到达n位数的第几位（左起是第1位，最右是第n位）
- 边界条件：
  - index == n
- 前进段：
  - 对下一位进行全排列（0~9），index + 1
- 返回段：
  - 空返回，当index == n时打印
    - 需要构造removeZeroPrinter的打印方法
      - 打印方法需要考虑：不打印第一个数 0、不打印0后的空格

##### 特殊输入

- n等于0或小于0

##### 核心代码

```java
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
```



### 面试题22：链表中倒数第k个节点

#### [题目](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

- 思路1：第一次遍历得到链表的节点个数n，第二次遍历找出第n - k个节点
- 思路2：一次遍历，利用两个指针，使它们间隔k - 1（实际中不一定是k - 1，取决于index是先自增，还是判断后再自增）

##### 思路2

- 起始：两个指针均指向head
- 快的指针先走k - 1个节点，从第k个节点开始，两个指针同时走（实际可能是k，要看index自增的位置）
- 结束：快的指针的next为空

##### 特殊输入

- 链表为空：返回null
- k等于0或k小于0：返回null
- 链表长度小于k：返回null

##### 核心代码

``` java
	public static ListNode getKthFromEnd(ListNode head, int k) {
		if(head == null)
			return null;
		if(k <= 0)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		int index = 1;
		while(fast.next != null) {
			fast = fast.next;
			index++;
			if(index > k)
				slow = slow.next;
		}
		if(index < k)
			return null;
		return slow;
	}
```

### 面试题23：链表中环的入口节点

#### 题目

如果一个链表中包含环，如何找出环的入口节点？例如，在如图3.8所示的链表中，环的入口节点是3。

- 思路1
  - 确定是否有环
  - 统计环中的节点数n
  - 确定入口节点

##### 思路1

- 确定是否有环：快（一次移动2）、慢（一次移动1）指针
  - 快指针的下一步为空，无环
  - 重合即有环
- 统计环中的节点数n：上述慢指针走回自己的位置，即统计出环中的节点数n
  - 实际中这一步是与上一步同时做的，所以返回0代表无环，返回大于0代表环中的节点数n

- 确定入口节点：利用两个指针，使它们间隔n，行进速度相同（都是1）
  - 当二者重合时，即是环的入口

##### 特殊输入

- 链表为空
- 链表无环

##### 核心代码

```java
	public static ListNode findRingEntry(ListNode head) {
		int n = hasRing(head);
		if(n == 0)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		int index = 0;
		while(true) {
			fast = fast.next;
			index++;
			if(index > n)
				slow = slow.next;
			if(slow == fast)
				return slow;
		}
	}
	
	public static int hasRing(ListNode head) {
		if(head == null)
			return 0;
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				ListNode temp = slow;
				int number = 0;
				while(true) {
					slow = slow.next;
					number++;
					if(slow == temp)
						break;
				}
				return number;
			}
		}
		return 0;
	}
```

### 面试题24：反转链表

### [题目](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

- 思路1: 三个指针，分别指向last、current和next

##### 思路1

- 初始条件
  - last指向null
  - current指向head
  - next指向head.next
- 循环体内（next为空结束循环，结束后将current指向last）
  - 反转
    - current指向last
  - 移动到下一节点
    - last指向current
    - current指向next
    - next指向next.next

##### 特殊输入

- 链表为空
- 链表只有一个头节点（不用额外考虑，下面代码while循环条件规避了这一问题）

##### 核心代码

```java
	public static ListNode reverseList(ListNode head) {
		if(head == null)
			return null;
		ListNode last = null;
		ListNode current = head;
		ListNode next = head.next;
		while(next != null) {
			current.next = last;
			last = current;
			current = next;
			next = next.next;
		}
		current.next = last;
		return current;
	}
```

### 面试题25：合并两个排序的链表

#### [题目](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)

输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。例如，输入图3.11中的链表1和链表2，则合并之后的升序链表如链表3所示。

- 思路1：取两个链表头的较小值作为头，递归取头的next

##### 思路1

- 递归参数：
  - 两个链表的头
- 边界条件：
  - 某个链表的头为空
    - l1为空，返回l2
    - l2为空，返回l1
- 前进段：
  - 取两个链表头的较小值作为当前头
  - 当前头的next
    - 如果l1的头的值较小
      - 则l2 = l2.next
    - 如果l2的头的值较小
      - 则l1 = l1.next
- 返回段：
  - 返回当前头

##### 特殊输入

- l1和（或）l2为空：不用加以特殊处理，因为下面代码中递归边界条件规避了相关情形

##### 核心代码

```java
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode listNode = null;
		if(l1.val <= l2.val) {
			listNode = l1;
			listNode.next = mergeTwoLists(l1.next, l2);
		}
		else {
			listNode = l2;
			listNode.next = mergeTwoLists(l1, l2.next);
		}
		return listNode;
	}
```



### 面试题26：树的子结构



### [题目](https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/)

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

- 思路1：二层递归
  - 外层前序遍历A树，判断当前节点与B的根节点值是否相同
  - 内层同时遍历A的子树、B树，判断从A从当前节点开始的子树是否包含B树

##### 思路1

- 外层递归
  - 递归参数：
    - A、B树
  - 边界条件：
    - B为空：false（出于leetcode题目的要求，同时便于为下一步判断增加前置条件）
    - A当前节点为空（B不为空）：false
    - 同时内层递归还会为外层递归带来”边界“（如果内层返回了true，则不会继续遍历）
  - 前进段：
    - 如果A的当前节点值等于B的根的值
      - 进入内层递归
    - 如果上述的结果为false
      - 进入A的左子树
    - 如果上述的结果（包含第一条和第二条）为false
      - 进入右子树
  - 返回段：
    - 返回当前的result
- 内层递归
  - 递归参数：
    - A的子树、B树
  - 边界条件：
    - B当前节点为空，代表遍历B完成且未发现不同值的节点：true
    - A当前节点为空（B当前节点不为空）：false
  - 前进段：
    - 如果A的当前节点值等于B的当前节点值
      - 比较A.left与B.left
      - 比较A.right与B.right
    - 不相等：false
  - 返回段：
    - 返回A、B左右子树对比的与

##### 特殊输入

- A和（或）B为空
- B的根对应的值位于A最下层的叶子节点（或者其他会导致A为空但B不为空的情形：会导致外层递归的错误）

##### 核心代码

```java
	public static boolean isSubStructure(TreeNode A, TreeNode B) {
		if(B == null)
			return false;
		if(A == null)
			return false;
		boolean result = false;
		if(A.val == B.val)
			result = compareTree(A, B);
		if(!result)
			result = isSubStructure(A.left, B);
		if(!result)
			result = isSubStructure(A.right, B);
		return result;
	}
	
	public static boolean compareTree(TreeNode A, TreeNode B) {
		if(B == null)
			return true;
		if(A == null)
			return false;
		if(A.val == B.val)
			return compareTree(A.left, B.left) && compareTree(A.right, B.right);
		else
			return false;
	}
```

### 面试题27：二叉树的镜像

#### [题目](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)

请完成一个函数，输入一个二叉树，该函数输出它的镜像。

- 思路1：交换当前节点的左右子树（递归实现）

##### 思路1

- 递归参数：
  - 树的当前节点
- 边界条件：
  - 当前节点的左右子树都为空
- 前进段：
  - 如果左子树不为空
    - 递归交换左子树的左右子树
  - 如果右子树不为空
    - 递归交换右子树的左右子树
- 返回段：
  - 返回根节点（子树的根节点虽然返回，但无任何赋值操作）

##### 特殊输入

- 树为空
- 树只有根节点
- 树是歪脖子（或者退化为链表的树）

##### 核心代码

``` java
	public static TreeNode mirrorTree(TreeNode root) {
		if(root == null)
			return null;
		if(root.left != null || root.right != null) {
			swap(root);
			if(root.left != null)
				mirrorTree(root.left);
			if(root.right != null)
				mirrorTree(root.right);
		}
		return root;
	}
```



### 面试题28：对称的二叉树

#### [题目](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)

请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。例如，在如图4.3所示的3棵二叉树中，第一棵二叉树是对称的，而另外两棵不是。

- 思路1：根左右的前序遍历，和根右左的”前序遍历“对比（递归实现）

##### 思路1

- 递归参数：
  - 树的左、右子树
- 边界条件：
  - 左、右都为空：true
  - 左、右之一为空（不都为空，基于上一条）：false
  - 左、右值不相等：false
- 前进段：
  - 左、右值相等
    - 递归对比左的left和右的right
    - 以及左的right和右的left
      - 这里的本质是根左右与根右左
- 返回段：
  - 返回左的left和右的right，和左的right和右的left的与

##### 特殊输入

- 树为空
- 树只有根节点（递归边界考虑，不用额外处理）
- 树只有左子树（递归边界考虑，不用额外处理）

##### 核心代码

```java
	public static boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}
	
	public static boolean isSymmetric(TreeNode A, TreeNode B) {
		if(A == null && B == null)
			return true;
		if(A == null || B == null)
			return false;
		if(A.val == B.val)
			return isSymmetric(A.left, B.right) && isSymmetric(A.right, B.left);
		else
			return false;
	}
```

### 面试题29：顺时针打印矩阵

#### [题目](https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

- 思路1：每次都从(start, start)位置开始，分向右、向下、向左、向上四步考虑（循环实现）

#### 思路1

- 参数
  - start：当前起始位置
  - rowEnd、colEnd：当前行、列的最后一个下标

- 初始条件
  - start为0
  - rowEnd、colEnd为长度-1
- 循环体内（矩阵宽度、长度都大于2 * start）
  - printer函数
    - 向右条件：colEnd大于start
      - 行打印：从start打印到colEnd
    - 向下条件：rowEnd大于start
      - 列打印：从start + 1打印到rowEnd
    - 向左条件：rowEnd大于start，且colEnd大于start
      - 行打印：从colEnd - 1打印到start
    - 向上条件：rowEnd大于start + 1，且colEnd大于start
      - 列打印：从rowEnd - 1打印到start + 1
  - start + 1
  - rowEnd、colEnd - 1

#### 特殊输入

- 矩阵为空
- 矩阵长度为0
- 矩阵只有1个数、1行、1列

#### 核心代码

```java
	public static int[] spiralOrder(int[][] matrix) {
		if(matrix == null)
			return null;
		if(matrix.length == 0 || matrix[0].length == 0)
			return new int[0];
		int colEnd = matrix[0].length;
		int rowEnd = matrix.length;
		int[] result = new int[colEnd-- * rowEnd--];
		int start = 0;
		int index = 0;
		while(matrix[0].length > 2 * start && matrix.length > 2 * start)
			index = printer(result, matrix, start++, colEnd--, rowEnd--, index);
		return result;
	}
	
	public static int printer(int[] result, int[][] matrix, 
			int start, int colEnd, int rowEnd, int index) {
		if(colEnd >= start)
			for(int i = start; i <= colEnd; i++)
				result[index++] = matrix[start][i];
		if(rowEnd > start)
			for(int i = start + 1; i <= rowEnd; i++)
				result[index++] = matrix[i][colEnd];
		if(colEnd > start && rowEnd > start)
			for(int i = colEnd - 1; i >= start; i--)
				result[index++] = matrix[rowEnd][i];
		if(colEnd > start && rowEnd > start + 1)
			for(int i = rowEnd - 1; i > start; i--)
				result[index++] = matrix[i][start];
		return index;
	}
```

### 面试题30：包含min函数的栈

#### [题目](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数。在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

- 思路1：利用辅助栈来保存当前的最小值

##### 思路1

- 压入：
  - 如果主栈为空
    - 将当前值压入主栈和辅助栈
  - 如果主栈不为空
    - 将当前值压入主栈
    - 判断主栈栈顶元素与当前值的大小关系
      - 当前值小于主栈栈顶元素
        - 将当前值压入辅助栈
      - 当前值大于等于主栈栈顶元素
        - 将辅助栈栈顶元素压入辅助栈
- 弹出：
  - 弹出主栈
  - 弹出辅助栈
- top()：
  - 返回主栈栈顶元素
- min()：
  - 返回辅助栈栈顶元素

##### 特殊输入

- 未push情况下直接pop、top、min（**应该考虑异常处理**）

##### 核心代码

```java
class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
    /** initialize your data structure here. */
    public MinStack() {
    	stack = new Stack<>();
    	minStack = new Stack<>();
    }
    
    public void push(int x) {
    	if(stack.isEmpty()) {
    		stack.push(x);
    		minStack.push(x);
    	} else {
    		stack.push(x);
    		if(x < minStack.peek())
    			minStack.push(x);
    		else
    			minStack.push(minStack.peek());
    	}
    	
    }
    
    public void pop() {
    	if(stack.isEmpty())
    		return;
    	stack.pop();
    	minStack.pop();
    }
    
    public int top() {
    	if(stack.isEmpty())
    		return -1;
    	return stack.peek();
    }
    
    public int min() {
    	if(stack.isEmpty())
    		return -1;
    	return minStack.peek();
    }
}
```

### 面试题31：栈的压入、弹出序列

#### [题目](https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/)

- 思路1：构建一个栈来模拟压入弹出操作（循环实现）

##### 思路1

- 参数
  - pushed、poped数组的下标

- 初始条件
  - indexPushed、indexPoped都为0
- 循环体内（死循环）
  - 如果栈为空
    - 将pushed的当前元素压入栈，并指向下一个元素
  - 如果栈不为空
    - 如果poped的当前元素等于栈顶元素
      - 弹出栈，并将poped指向下一个元素
      - 如果poped指向了最后一个元素的下一个
        - 返回true
    - 如果poped的当前元素不等于栈顶元素
      - 如果pushed没有指向最后一个元素的下一个
        - 将pushed的当前元素压入栈
      - 如果pushed指向最后一个元素的下一个
        - 返回false

##### 特殊输入

- pushed和poped同时为空：ture
- pushed或poped为空：false
- pushed和poped的长度同时为0：ture
- pushed或poped的长度为0：false

##### 核心代码

```java
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		if(pushed == null && popped == null)
			return true;
		if(pushed == null || popped == null)
			return false;
		if(pushed.length == 0 && popped.length == 0)
			return true;
		if(pushed.length == 0 || popped.length == 0)
			return false;
		Stack<Integer> stack = new Stack<>();
		int indexPushed = 0;
		int indexPoped = 0;
		while(true) {
			if(stack.isEmpty()) 
				stack.push(pushed[indexPushed++]);
			else
				if(popped[indexPoped] == stack.peek()) {
					popped[indexPoped++] = stack.pop();
					if(indexPoped == popped.length)
						return true;
				}
				else
					if(indexPushed < pushed.length)
						stack.push(pushed[indexPushed++]);
					else
						return false;
		}
	}
```

### 面试题32：从上到下打印二叉树

#### [题目一：不分行从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)

从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。例如，输入图4.6中的二叉树，则依次打印出8, 6, 10, 5, 7, 9, 11。

- 思路1：利用队列，先进先出（循环实现）

##### 思路1

- 初始条件
  - root入队
- 循环体内（队列不为空）
  - 出队并存入数组
  - 如果当前节点有左子树
    - 左子树入队
  - 如果当前节点有右子树
    - 右子树入队

##### 特殊输入

- 树为空
- 树只有根节点
- 树是歪脖子（或者退化为链表的树）

##### 核心代码

```java
	public static int[] levelOrder(TreeNode root) {
		if(root == null)
			return new int[0];
		ArrayList<Integer> arrayList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			arrayList.add(temp.val);
			if(temp.left != null)
				queue.offer(temp.left);
			if(temp.right != null)
				queue.offer(temp.right);
		}
		int[] result = new int[arrayList.size()];
		for(int i = 0; i < arrayList.size(); i++)
			result[i] = arrayList.get(i);
		return result;
	}
```

#### [题目二：分行从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。例如打印图4.7中的二叉树结果为：

8

6	10

5	7	9	11

- 思路1：利用队列，先进先出（循环实现）
  - 增加两个变量currentLevel和nextLevel来统计当前层的节点数和下一层的节点数来控制换行

##### 思路1

- 参数
  - currentLevel和nextLevel
- 初始条件
  - currentLevel为1（因为根节点算1个）
  - nextLevel
- 循环体内（死循环）
  - 出队并存入数组，currentLevel--
  - 如果当前节点有左子树
    - 左子树入队，nextLevel++
  - 如果当前节点有右子树
    - 右子树入队，nextLevel++
  - 如果currentLevel为0
    - 换行：实际操作为将目前临时ArrayList添加到结果中，并清空ArrayList
      - 注意拷贝方式
    - currentLevel = nextLevel，nextLevel = 0

##### 特殊输入

- 树为空
- 树只有根节点
- 树是歪脖子（或者退化为链表的树）

##### 核心代码

```java
	public static List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null)
			return new ArrayList<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		int currentLevel = 1;
		int nextLevel = 0;
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			arrayList.add(temp.val);
			currentLevel--;
			if(temp.left != null) {
				queue.offer(temp.left);
				nextLevel++;
			}
			if(temp.right != null) {
				queue.offer(temp.right);
				nextLevel++;
			}
			if(currentLevel == 0) {
				currentLevel = nextLevel;
				nextLevel = 0;
				ArrayList<Integer> tempArrayList = new ArrayList<>();
				for(int i : arrayList)
					tempArrayList.add(i);
				result.add(tempArrayList);
				arrayList.clear();
			}
		}
		return result;
	}
```

#### [题目三：之字形打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)

请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。例如，按之字形顺序打印图4.8中二叉树的结果为：

1

3	2

4	5	6	7

15	14	13	12	11	10	9	8

- 思路1：利用栈，后进先出（循环实现）
  - 但要利用两个栈，而不是一个栈：分奇数层栈oddStack、偶数层栈evenStack
    - 奇数层先左后右
    - 偶数层先右后左

##### 思路1

- 参数
  - levelFlag：奇偶层标志，根为奇数层，奇数：true，偶数：false
- 初始条件
  - levelFlag为true
- 循环体内（死循环）
  - 如果是奇数层（levelFlag为true）
    - oddStack出栈，并存入数组
    - 如果当前节点有左子树
      - evenStack入栈
    - 如果当前节点有右子树
      - evenStack入栈
    - 如果oddStack为空，levelFlag设为false，并换行：实际操作为将目前临时ArrayList添加到结果中，并清空ArrayList
      - 注意拷贝方式
  - 如果是偶数层（levelFlag为false）
    - evenStack出栈，并存入数组
    - 如果当前节点有右子树
      - oddStack入栈
    - 如果当前节点有左子树
      - oddStack入栈
    - 如果evenStack为空，levelFlag设为true，并换行：实际操作为将目前临时ArrayList添加到结果中，并清空ArrayList
      - 注意拷贝方式

##### 特殊输入

- 树为空
- 树只有根节点
- 树是歪脖子（或者退化为链表的树）

##### 核心代码

```java
	public static List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null)
			return new ArrayList<>();
		Stack<TreeNode> stackOdd = new Stack<>();
		Stack<TreeNode> stackEven = new Stack<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		boolean levelFlag = true;
		stackOdd.push(root);
		
		while(!stackOdd.isEmpty() || !stackEven.isEmpty()) {
			TreeNode temp;
			if(levelFlag) {
				temp = stackOdd.pop();
				arrayList.add(temp.val);
				if(temp.left != null)
					stackEven.push(temp.left);
				if(temp.right != null)
					stackEven.push(temp.right);
				if(stackOdd.isEmpty()) {
					levelFlag = false;
					addToResult(result, arrayList);
				} 
			} else {
				temp = stackEven.pop();
				arrayList.add(temp.val);
				if(temp.right != null)
					stackOdd.push(temp.right);
				if(temp.left != null)
					stackOdd.push(temp.left);
				if(stackEven.isEmpty()) {
					levelFlag = true;
					addToResult(result, arrayList);
				}
			}
		}
		return result;
    }
	
	public static void addToResult(List<List<Integer>> result, List<Integer> arrayList) {
		ArrayList<Integer> tempArrayList = new ArrayList<>();
		for(int i : arrayList)
			tempArrayList.add(i);
		result.add(tempArrayList);
		arrayList.clear();
	}
```

### 面试题33：二叉搜索树的后序遍历序列

#### [题目](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。例如，输入数组{5, 7, 6, 9, 10, 8}，则返回true，因为这个整数序列是图4.9二叉搜索树的后序遍历结果，如果输入的数组是{7, 4, 6, 5}，则由于没有哪棵二叉搜索树的后序遍历结果是这个序列，因此返回false。

- 思路1：遍历数组，确定右子树范围（递归实现）
  - 如果右子树中存在比根小的，则返回false
  - 如果没有，递归左右子树

##### 思路1

- 递归参数：
  - 后序遍历数组
  - 当前子树起始位置start
  - 当前子树结束位置end
- 边界条件：
  - start == end
    - 代表当前子树只有根，返回true
- 前进段：
  - 先遍历当前数组（循环实现）
    - 初值：`middle = end;` `middleFlag = true;`
    - 把第一个值大于根的位置记为middle，同时把middleFlag设为false
    - 在middle后的元素中，如果有元素小于根：返回false
  - 递归左、右子树
- 返回段（**这里可优化，参考181页**）：
  - 如果middle == end
    - 返回左子树
  - 如果middle == start
    - 返回右子树
  - 其他情况
    - 返回左右子树的与

##### 特殊输入

- 数组为空
- 数组长度为0
- 子树某部分只有左子树或只有右子树（歪脖子）
  - 测试用例：`int[] postorder = {1, 2, 5, 10, 6, 9, 4, 3};`

##### 核心代码

```java
	public static boolean verifyPostorder(int[] postorder) {
		if(postorder == null)
			return false;
		if(postorder.length == 0)
			return true;
		return recur(postorder, 0, postorder.length - 1);
    }
	
	public static boolean recur(int [] postorder, int start, int end) {
		if(start == end)
			return true;
		int middle = end;
		boolean middleFlag = true;
		for(int i = start; i <= end; i++) {
			if(postorder[i] > postorder[end] && middleFlag) {
				middleFlag = false;
				middle = i;
			}
			if(i < middle)
				if(postorder[i] > postorder[end])
					return false;
				else
					continue;
			else
				if(postorder[i] < postorder[end])
					return false;
		}
		if(middle == end)
			return recur(postorder, start, middle - 1);
		else if(middle == start)
			return recur(postorder, middle, end - 1);
		else
			return recur(postorder, start, middle - 1) && recur(postorder, middle, end - 1);
	}
```

### 面试题34：二叉树中和为某一值的路径

#### [题目](https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)

输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

- 思路1：利用辅助栈（双端队列实现，便于返回路径）遍历二叉树（递归实现）

##### 思路1

- 递归参数：
  - 当前根节点
  - 辅助栈（双端队列）
  - 保存结果的List<List\<Integer>>
  - 目标值
  - 当前值
- 边界条件：
  - 当前值等于目标值，且当前根节点无左右子树：将当前路径（双端队列）添加到结果中
- 前进段：
  - 当前根节点的值入栈，当前值加1
  - 如果左子树不为空
    - 递归计算左子树
  - 如果右子树不为空
    - 递归计算右子树
  - 出栈，当前值减1
- 返回段：
  - 无返回

##### 特殊输入

- 树为空
- 树只有根节点

##### 核心代码

```java
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		if(root == null)
			return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<>();
		recur(root, deque, result, sum, 0);
		return result;
    }
	
	public static void recur(TreeNode root, Deque<Integer> deque, List<List<Integer>> result, 
			int targerVal, int currentVal) {
		deque.push(root.val);
		currentVal += deque.peek();
		if(currentVal == targerVal && root.left == null && root.right == null) {
			Iterator<Integer> iterator = deque.descendingIterator();
			ArrayList<Integer> arrayList = new ArrayList<>();
			while(iterator.hasNext())
				arrayList.add(iterator.next());
			result.add(arrayList);
		}
		if(root.left != null)
			recur(root.left, deque, result, targerVal, currentVal);
		if(root.right != null)
			recur(root.right, deque, result, targerVal, currentVal);
		currentVal -= deque.peek();
		deque.pop();
	}
```

### 面试题35：复杂链表的复制

#### [题目](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)

请实现 copyRandomList* Clone(ComplexListNode* pHead) 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 m_pSibling指针指向链表中的任意节点或者 null。

- 思路1：两层遍历，外层遍历节点，内层遍历寻找random
  - 时间复杂度O(n^2)
- 思路2：一层遍历，利用哈希表找复制前和复制后节点对应关系以寻找random
  - 时间复杂度O(n)
  - 空间复杂度O(n)
- 思路3：一层遍历，分三步实现节点的复制（分治）

##### 思路3

- 第一步，将复制后的节点放在原链表对应节点的后面
  - 新建一个节点（深拷贝问题），将它指向当前节点的下一个节点
  - 让当前节点指向新建的节点
  - 当前节点后移
  - **注意**：在`Node current = head;`中，current是head的引用（指针，更容易理解）
    - 所以`current = current.next;`操作并不会影响head（指针移动）
    - 而`current.next = nodeCopy;`操作会影响head（改变指针所指位置的值）
- 第二步，将原链表中每个节点后面节点的random指向这个节点的random的后面节点
  - next节点指向当前节点的下一个节点
  - 如果当前节点的random指针不为空
    - next的random指向当前节点的random的下一个节点
  - 当前节点指向next的下一个节点
- 第三步，将原链表拆分：奇数节点成为原链表，偶数节点成为复制链表
  - 处理链表头节点
    - current指向头节点
    - headCopy指向头节点的下一个节点
    - currentCopy指向headCopy
    - current.next指向currentCopy.next
    - current后移
  - 循环处理所有剩余节点（current不为空）
    - currentCopy.next指向current.next
    - currentCopy后移
    - current.next指向currentCopy.next
    - current后移
    - 返回headCopy

##### 特殊输入

- 链表为空
- 链表只有头节点

##### 核心代码

```java
	public static Node copyRandomList(Node head) {
		if(head == null)
			return null;
		copyAndMerge(head);
		addRandom(head);
        return split(head);
    }
	
	public static void copyAndMerge(Node head) {
		Node current = head;
		while(current != null) {
			Node nodeCopy = new Node(current.val);
			nodeCopy.next = current.next;
			nodeCopy.random = null;
			current.next = nodeCopy;
			current = nodeCopy.next;
		}
	}
	
	public static void addRandom(Node head) {
		Node current = head;
		while(current != null) {
			Node next = current.next;
			if(current.random != null)
				next.random = current.random.next;
			current = next.next;
		}
	}
	
	public static Node split(Node head) {
		Node current = head;
		Node headCopy = current.next;
		Node currentCopy = headCopy;
		current.next = currentCopy.next;
		current = current.next;
		while(current != null) {
			currentCopy.next = current.next;
			currentCopy = currentCopy.next;
			current.next = currentCopy.next;
			current = current.next;
		}
		return headCopy;
	}
```

### 面试题36：二叉搜索树与双向链表

#### [题目](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。比如，输入图4.15中左边的二叉搜索树，则输出转换之后的排序双向链表。

- 思路1：中序遍历（递归实现）
  - 考虑最左叶子与根的关系，及该根与其右叶子的关系：这三者可以转化成一个双向链表
  - 其他节点之间的关系均可抽象成某节点与左“叶子”、右“叶子”的关系

##### 思路1

- 递归参数：
  - 当前根节点
  - 上一个节点：中序遍历保证了节点值由小到大，所以上树中一个节点也是链表中上一个节点
    - last初值为空
- 边界条件：
  - 当前值等于目标值，且当前根节点无左右子树：将当前路径（双端队列）添加到结果中
- 前进段：
  - 如果当前节点有左子树
    - 递归调用左子树：返回last
  - 当前节点的left等于last
  - 如果last非空
    - last的right等于当前节点
  - last等于当前节点
  - 如果当前节点有右子树
    - 递归调用右子树：返回last
- 返回段：
  - 返回last

##### 特殊输入

- 树为空
- 树只有根节点

##### 核心代码

```java
	public static Node treeToDoublyList(Node root) {
		if(root == null)
			return null;
		recur(root, null);
		Node first = root;
		while(first.left != null)
			first = first.left;
		Node last = root;
		while(last.right != null)
			last = last.right;
		first.left = last;
		last.right = first;
        return first;
    }
	
	public static Node recur(Node root, Node last) {
		if(root.left != null)
			last = recur(root.left, last);
		root.left = last;
		if(last != null)
			last.right = root;
		last = root;
		if(root.right != null)
			last = recur(root.right, last);
		return last;
	}
```

### 面试题37：序列化二叉树

#### [题目](https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/)

请实现两个函数，分别用来序列化和反序列化二叉树。

- 思路1：

##### 思路1

##### 特殊输入

##### 核心代码

```java

```

### 面试题38：字符串的排列

#### [题目](https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/)

输入一个字符串，打印出该字符串中字符的所有排列。例如，输出字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。

- 思路1：

##### 思路1

##### 特殊输入

##### 核心代码

```java

```

### 面试题39：数组中出现次数超过一半的数字

#### [题目](https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如，输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。

- 思路1：

##### 思路1

##### 特殊输入

##### 核心代码

```java

```

### 面试40：最小的k个数

#### [题目](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

输入整数数组 n ，找出其中最小的 k个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

- 思路1：

##### 思路1

##### 特殊输入

##### 核心代码

```java

```

























