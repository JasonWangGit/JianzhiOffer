### 快速排序

```java
public static int[] sort(int[] nums) {
    recur(nums, 0, nums.length - 1);
    return nums;
}
	
public static void recur(int[] nums, int left, int right) {
    if(left < right) {
        int middle = partition(nums, left, right);
        recur(nums, left, middle - 1);
        recur(nums, middle + 1, right);
    }
}

public static int partition(int[] nums, int left, int right) {
    if(left == right) return left;
    int pivotal = nums[left];
    int i = left + 1, j = right;
    while(true) {
        while(nums[i] < pivotal && i < right) i++;
        while(nums[j] > pivotal && j > left) j--;
        if(i < j) swap(nums, i, j);
        else break;
    }
    swap(nums, left, j);
    return j;
}

public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```

### 线程安全单例模式

```java
public class SingletonThreadSafe {
	private static volatile SingletonThreadSafe singletonInstance;
    
    private static SingletonThreadSafe();
    
    public static getInstance() {
        if(singletonInstance == null) {
            synchronized(SingletonThreadSafe.class) {
                if(singletonInstance == null) {
                    singletonInstance = new SingletonThreadSafe();
                }
            }
        }
        return singletonInstance;
    }
}
```

### 面试题3：数组中重复的数字

#### [题目一：找出数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof)

在一个长度为 n 的数组里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。

```java
public int findRepeatNumber(int[] nums) {
    if(nums == null || nums.length == 0) return -1;
    for(int i = 0; i < nums.length; i++) {
        if(i < 0 || i > nums.length - 1) return -1;
        while(nums[i] != i) {
            if(nums[nums[i]] == nums[i]) return nums[i];
            else swap(nums, i, nums[i]);
        }
    }
    return -1;
}

public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```

### 面试题4：二维数组中的查找

#### [题目](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof)

在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

```java
public boolean findNumberIn2DArray(int[][] matrix, int target) {
    if(matrix == null || matrix.length == 0) return false;
    int i = 0, j = matrix[0].length - 1;
    while(i < matrix.length && j >= 0)
        if(matrix[i][j] == target) return true;
        else if(matrix[i][j] > target) j--;
        else i++; 
    return false;
}
```

### 面试题5 替换空格

#### [题目](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

请实现一个函数，把字符串中的每个空格替换成"%20"。例如，输入"We are happy."，则输出"We%20are%20happy."。

```java
public String replaceSpace(String s) {
	return s.replaceAll(" ", "%20");
}

public String replaceSpace(String s) {
    if(s == null) return null;
    if(s.length() == 0) return "";
	StringBuilder stringBuilder = new StringBuilder();
    for(int i = 0; i < s.length(); i++)
        if(s.charAt(i) == ' ') stringBuilder.append("%20");
    	else stringBuilder.append(s.charAt(i));
    return stringBuilder.toString();
}
```

### 面试题6 从尾到头打印链表

#### [题目](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

```java
public int[] reversePrint(ListNode head) {
    Stack<Integer> stack = new Stack<>();
    int index = 0;
    while(head != null) {
        index++;
        stack.push(head.val);
        head = head.next;
    }
    int[] nums = new int[index];
    for(int i = 0; i < index; i++)
        nums[i] = stack.pop();
    return nums;
}
```

### 面试题7 重建二叉树

#### [题目](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如，输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建如图2.6所示的二叉树并输出它的头节点。

```java
public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
    return recur(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
}

public TreeNode recur(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
    TreeNode root = new TreeNode(preorder[preLeft]);
    int inRoot = 0;
    for(int i = inLeft; i <= inRight; i++)
        if(inorder[i] == root.val) {
            inRoot = i;
            break;
        }
    int leftLength = inRoot - inLeft;
    if(inLeft == inRight) {
        return root;
    } else if(inRoot == inRight) {
        root.left = recur(preorder, inorder, preLeft + 1, preRight, inLeft, inRight - 1);
    } else if(inRoot == inLeft) {
        root.right = recur(preorder, inorder, preLeft + 1, preRight, inLeft + 1, inRight);
    } else {
        root.left = recur(preorder, inorder, preLeft + 1, preLeft + leftLength, inLeft, inRoot - 1);
        root.right = recur(preorder, inorder, preLeft + leftLength + 1, preRight, inRoot + 1, inRight);
    }
    return root; 
}
```

### 面试题8 二叉树的下一个节点

#### 题目

给定一颗二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？树中的节点除了有两个分别指向左右子节点的指针，还有一个指向父节点的指针。

```java
public static TreeNode findNext(TreeNode root, TreeNode treeNode) {
    if(root == null) return null;
    if(treeNode.right != null) {
        TreeNode current = treeNode.right;
        while(current.left != null) current = current.left;
        return current;
    } else if(root.parent == null) return null;
    else if(treeNode == treeNode.parent.left)
        return treeNode.parent;
    else {
        TreeNode current = treeNode.parent;
        
        while(current != current.parent.left) {
            current = current.parent;
            if(current == root) return null;
        }
        return current;
    }
}
```

### 面试题9 用两个栈实现队列

#### [题目](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。

```java
Stack<Integer> stack1;
Stack<Integer> stack2;

public CQueue() {
	stack1 = new Stack<>();
    stack2 = new Stack<>();
}
    
public void appendTail(int value) {
	stack1.push(value);
}
    
public int deleteHead() {
    if(stack1.isEmpty() && stack2.isEmpty()) return -1;
    else {
        if(stack2.isEmpty())
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }
}
```

### 面试题10 斐波那契数列

#### [题目一：求斐波那契数列的第n项](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)

写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
$$
f(n) = \begin{cases} 0 & \text{n = 0} \\ 1 & \text{n = 1} \\ f(n-1)+f(n-2) & \text{n > 1} \end{cases}
$$

```java
public int fib(int n) {
    if(n <= 0) return 0;
    if(n == 1) return 1;
    int f_n_2 = 0;
    int f_n_1 = 1;
    int f_n = 0;
    for(int i = 2; i <= n ; i++) {
        f_n = (f_n_1 + f_n_2) % 1000000007;
        f_n_2 = f_n_1;
        f_n_1 = f_n;
    }
    return f_n;
}
```

#### [题目二：青蛙跳台阶问题](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)

```java
public int numWays(int n) {
    if(n <= 1) return 1;
    if(n == 2) return 2;
    int f_n_2 = 1;
    int f_n_1 = 2;
    int f_n = 0;
    for(int i = 3; i <= n ; i++) {
        f_n = (f_n_1 + f_n_2) % 1000000007;
        f_n_2 = f_n_1;
        f_n_1 = f_n;
    }
    return f_n;
}
```

### 面试题11：旋转数组的最小数字

#### [题目](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为1。  

```java
public int minArray(int[] numbers) {
    if(numbers == null || numbers.length == 0) return -1;
    if(numbers[0] < numbers[numbers.length - 1]) return numbers[0];
    int left = 0, right = numbers.length - 1;
    while(left == right - 1) {
        int middle = (left + right) << 1;
        if(numbers[middle] == numbers[left] && numbers[middle] == numbers[right]) {
            int min = numbers[left];
            for(int i = left; i <= right; i++) {
                min = Math.min(min, numbers[i]);
            }
            return min;
        } else if(numbers[middle] >= numbers[left]) left = middle;
        else if(numbers[middle] <= numbers[right]) right = middle;
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

```java
public boolean exist(char[][] board, String word) {
    if(word == null) return true;
    if(board == null) return false;
    if(word.length() == 0) return true;
    if(board.length == 0) return false;
    if(word.length() > board.length * board[0].length) return false;
    boolean[][] isVisited = new boolean[board.length][board[0].length];
	for(int i = 0; i < board.length; i++)
        for(int j = 0; j < board[0].length; j++)
            if(recur(board, isVisited, word, 0, i, j))
                return true;
    return false;
}

public boolean recur(char[][] board, boolean[][] isVisited, String word, int index, int row, int col) {
    if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
    if(isVisited[row][col] || board[row][col] != word.charAt(index)) return false;
    if(index == word.length() - 1) return true;
    index++;
    isVisited[row][col] = true;
    boolean result = recur(board, isVisited, word, index, row + 1, col)
        || recur(board, isVisited, word, index, row - 1, col)
        || recur(board, isVisited, word, index, row, col + 1)
        || recur(board, isVisited, word, index, row, col - 1);
    isVisited[row][col] = false;
    return result;
}
```

### 面试题13：机器人的运动范围

#### [题目](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

地上有一个m行n列的方格 。一个机器人从坐标 (0, 0) 的格子开始移动，它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的**数位之和**大于k的格子。例如，当k为18时，机器人能够进入方格 (35, 37) ，因为3+5+3+7=18。但它不能进入方格 (35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

```java
public int movingCount(int m, int n, int k) {
    boolean[][] isVisited = new boolean[m][n];
    return recur(isVisited, 0, 0, k);
}

public int recur(boolean[][] isVisited, int m, int n, int k) {
    if(m < 0 || m >= isVisited.length || n < 0 || n >= isVisited[0].length) return 0;
    if(digitSum(m, n) > k || isVisited[m][n]) return 0;
    isVisited[m][n] = true;
    return 1 + recur(isVisited, m + 1, n, k) + recur(isVisited, m - 1, n, k)
        + recur(isVisited, m, n + 1, k) + recur(isVisited, m, n - 1, k);
}

public int digitSum(int m, int n) {
    int sum = 0;
    while(m != 0) {
        sum += m % 10;
        m /= 10;
    }
    while(n != 0) {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}
```

### 面试题14：剪绳子

#### [题目](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/)

```java
public int cuttingRope(int n) {
    if(n <= 1) return 0;
    if(n == 2) return 1;
    if(n == 3) return 2;
    int[] max = new int[n + 1];
    max[1] = 1;
    max[2] = 2;
    max[3] = 3;
    for(int i = 4; i <= n; i++) {
        max[i] = max[1] * max[i - 1];
        for(int j = 2; j <= (i >> 1); j++)
            max[i] = Math.max(max[i], max[j] * max[i - j]);
    }
    return max[n];
}

public int cuttingRope(int n) {
    if(n <= 1) return 0;
    if(n <= 3) return n - 1;
    if(n == 4) return 4;
    int result = 1;
    do {
        result *= 3;
        n -= 3;
    } while(n > 4);
    return result * n;
}
```

### 面试题15：二进制种1的个数

#### [题目](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)

```java
public int hammingWeight(int n) {
    int count = 0;
    while(n != 0) {
        if(n & 1 == 1) count ++;
        n >>>= 1;
    }
    return count;
}

public int hammingWeight(int n) {
    int count = 0;
    while(n != 0) {
        count ++;
        n &= n - 1;
    }
    return count;
}
```

### 面试题16：数值的整数次方（？Leetcode提交不通过）

#### [题目](https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/)

实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

```java
public double myPow(double x, int n) {
    if(n == 0)
        if(x == 0.0) return -1;
        else return 1;
    if(n < 0) {
        n = -n;
        x = 1 / x;
    }
    int result = 1;
    while(n > 0) {
        if((n & 1) == 1) result *= x;
        x *= x;
        n >>= 1;
    }
    return result;
}
```

### 面试题17：打印从1到最大的n位数

#### [题目](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)

输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

```java
public static void printBigNumbers(int n) {
	char[] result = new char[n];
    recur(result, n, 0)
}
	
public static void recur(char[] result, int n, int index) {
    if(index == n) {
        removeZeroPrinter(result);
        return;
    }
    for(int i = 0; i < 10; i++) {
        result[index] = (char)('0' + i);
        recur(result, n, index + 1);
    }
}

public static void removeZeroPrinter(char[] chars) {
    boolean startPrint = false;
    for(char c : chars) {
        if(c != '0' && !startPrint) startPrint = true;
        if(startPrint) System.out.print(c);
    }
    if(startPrint) System.out.print(" ");
}
```



### 面试题22：链表中倒数第k个节点

#### [题目](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

##### 核心代码

``` java
public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode fast = head;
    ListNode slow = head;
    int index = 0;
    while(fast != null) {
        fast = fast.next;
        if(index > k - 1) {
            slow = slow.next;
        }
        index++;
    }
    return slow;
}
```

### 面试题23：链表中环的入口节点

#### 题目

如果一个链表中包含环，如何找出环的入口节点？例如，在如图3.8所示的链表中，环的入口节点是3。

```java
public static ListNode findRingEntry(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    int index = 0;
    int k = hasRing(head);
    if(k == 0) return null;
    else {
        while(true) {
            fast = fast.next;
            if(index > k - 1) slow = slow.next;
            index++;
            if(fast == slow) return fast;
        }
    }
}

public static int hasRing(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    boolean ringFlag = false;
    int count = 0;
    ListNode temp = null;
    while(fast != null) {
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow && !ringFlag) {
            temp = slow;
            ringFlag = true;
        }
        if(ringFlag) {
            if(slow == temp && count != 0) break;
            count++;
        }
    }
    return count;
}
```

### 面试题24：反转链表

### [题目](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

```java
public ListNode reverseList(ListNode head) {
    if(head == null) return null;
    ListNode last = null, current = head, next = head.next;
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

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    ListNode head = null;
    if(l1.val < l2.val) {
        head = new ListNode(l1.val);
        head.next = mergeTwoLists(l1.next, l2);
    } else {
        head = new ListNode(l2.val);
        head.next = mergeTwoLists(l1, l2.next);
    }
    return head;
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
    - 如果上述的结果为false
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
public boolean isSubStructure(TreeNode A, TreeNode B) {
	if(B == null || A == null) return false;
    boolean result = false;
    if(A.val == B.val) result = checkStructure(A, B);
    if(!result) result = isSubStructure(A.left, B);
    if(!result) result = isSubStructure(A.right, B);
    return result;
}

public boolean checkStructure(TreeNode A, TreeNode B) {
    if(B == null) return true;
    if(A == null) return false;
    if(A.val == B.val) return checkStructure(A.left, B.left) && checkStructure(A.right, B.right);
    else return false;
}
```

### 面试题27：二叉树的镜像

#### [题目](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)

请完成一个函数，输入一个二叉树，该函数输出它的镜像。

``` java
public TreeNode mirrorTree(TreeNode root) {
    if(root == null) return null;
    if(root.left == null && root.right == null) return root;
    swap(root);
    if(root.left != null) mirrorTree(root.left);
    if(root.right != null) mirrorTree(root.right);
    return root;
}

public void swap(TreeNode root) {
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
}
```

### 面试题28：对称的二叉树

#### [题目](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)

请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。例如，在如图4.3所示的3棵二叉树中，第一棵二叉树是对称的，而另外两棵不是。

```java
public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    return recur(root.left, root.right);
}

public boolean recur(TreeNode left, TreeNode right) {
    if(left == null && right == null) return true;
    if(left == null || right == null) return false;
    if(left.val != right.val) return false;
    return recur(left.left, right.right) && recur(left.right, right.left);
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
    - 向右条件：colEnd大于等于start
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

``` java
public int[] spiralOrder(int[][] matrix) {
    if(matrix == null) return null;
    if(matrix.length == 0) return new int[0];
    int rowEnd = matrix.length, colEnd = matrix[0].length;
    int[] result = new int[rowEnd-- * colEnd--];
    int index = 0, start = 0;
    while(matrix.length > 2 * start && matrix[0].length > 2 * start) {
        for(int j = start; j <= colEnd; j++)
            result[index++] = matrix[start][j];
        if(rowEnd > start)
            for(int j = start + 1; j <= rowEnd; j++)
                result[index++] = matrix[j][colEnd];
        if(rowEnd > start && colEnd > start)
            for(int j = colEnd - 1; j >= start; j--)
                result[index++] = matrix[rowEnd][j];
        if(rowEnd > start + 1 && colEnd > start)
            for(int j = rowEnd - 1; j >= start + 1; j--)
                result[index++] = matrix[j][start];
        start++;
        rowEnd--;
        colEnd--;
    }
    return result;
}
```

### 面试题30：包含min函数的栈

#### [题目](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数。在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

```java
Stack<Integer> stack1;
Stack<Integer> stack2;
public MinStack() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
}
    
public void push(int x) {
    stack1.push(x);
    if(stack2.isEmpty()) stack2.push(x);
    else if(x < stack2.peek()) stack2.push(x);
    else stack2.push(stack2.peek());
}
    
public void pop() {
    stack1.pop();
    stack2.pop();
}
    
public int top() {
    return stack1.peek();
}
    
public int min() {
    return stack2.peek();
}
```

### 面试题31：栈的压入、弹出序列

#### [题目](https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/)

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列{1,2,3,4,5}是某栈的压栈序列，序列{4,5,3,2,1}是该压栈序列对应的一个弹出序列，但{4,3,5,1,2}就不可能是该压栈序列的弹出序列。

```java
public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    if(pushed == null && popped == null) return true;
    if(pushed == null || popped == null) return false;
    if(pushed.length == 0 && popped.length == 0) return true;
    if(pushed.length == 0 || popped.length == 0 || pushed.length != popped.length) return false;
    int indexPush = 0;
    int indexPop = 0;
    stack.push(pushed[indexPush++]);
    while(true) {
        while((stack.isEmpty() || stack.peek() != popped[indexPop]) && indexPush < pushed.length) {
            stack.push(pushed[indexPush++]);
        }
        if(stack.peek() == popped[indexPop]) {
            stack.pop();
            indexPop++;
            if(indexPop == popped.length) return true;
        } else {
            if(indexPush == pushed.length) return false;
        }
    }
}
```

### 面试题32：从上到下打印二叉树

#### [题目一：不分行从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)

```java
public int[] levelOrder(TreeNode root) {
    if(root == null) return new int[0];
    List<TreeNode> array = new ArrayList<>();
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
        if(queue.peek().left != null) queue.offer(queue.peek().left);
        if(queue.peek().right != null) queue.offer(queue.peek().right);
        array.add(queue.poll());
    }
    int[] result = new int[array.size()];
    for(int i = 0; i < array.size(); i++)
        result[i] = array.get(i).val;
    return result;
}
```

#### [题目二：分行从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null) return new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int currentLevel = 1, nextLevel = 0;
    List<Integer> temp = new ArrayList<>();
    while(!queue.isEmpty()) {
        if(queue.peek().left != null) {
            queue.offer(queue.peek().left);
            nextLevel++;
        }
        if(queue.peek().right != null) {
            queue.offer(queue.peek().right);
            nextLevel++;
        }
        temp.add(queue.poll().val);
        currentLevel--;
        if(currentLevel == 0) {
            currentLevel = nextLevel;
            nextLevel = 0;
            addToResult(result, temp);
        }
    }
    return result;
}

public void addToResult(List<List<Integer>> result, List<Integer> temp) {
    List<Integer> tempList = new ArrayList<>();
    for(int i : temp)
        tempList.add(i);
    result.add(tempList);
    temp.clear();
}
```

#### [题目三：之字形打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null) return new LinkedList<>();
    Deque<TreeNode> oddStack = new LinkedList<>();
    Deque<TreeNode> evenStack = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    boolean levelFlag = true;
    List<Integer> temp = new ArrayList<>();
    oddStack.push(root);
    while(!oddStack.isEmpty() || !evenStack.isEmpty()) {
        if(levelFlag) {
            if(oddStack.peek().left != null) evenStack.push(oddStack.peek().left);
            if(oddStack.peek().right != null) evenStack.push(oddStack.peek().right);
            temp.add(oddStack.pop().val);
            if(oddStack.isEmpty()) {
                addToResult(result, temp);
                levelFlag = false;
            }
        } else {
            if(evenStack.peek().right != null) oddStack.push(evenStack.peek().right);
            if(evenStack.peek().left != null) oddStack.push(evenStack.peek().left);
            temp.add(evenStack.pop().val);
            if(evenStack.isEmpty()) {
                addToResult(result, temp);
                levelFlag = true;
            }
        }
    }
    return result;
}

public void addToResult(List<List<Integer>> result, List<Integer> temp) {
    List<Integer> tempList = new ArrayList<>();
    for(int i : temp)
        tempList.add(i);
    result.add(tempList);
    temp.clear();
}
```

### 面试题33：二叉搜索树的后序遍历序列

#### [题目](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。例如，输入数组{5, 7, 6, 9, 10, 8}，则返回true，因为这个整数序列是图4.9二叉搜索树的后序遍历结果，如果输入的数组是{7, 4, 6, 5}，则由于没有哪棵二叉搜索树的后序遍历结果是这个序列，因此返回false。

```java
public boolean verifyPostorder(int[] postorder) {
    if(postorder == null || postorder.length == 0) return true;
    return recur(postorder, 0, postorder.length - 1);
}

public boolean recur(int[] postorder, int start, int end) {
    if(start == end) return true;
    boolean middleFlag = true;
    int middle = end;
    int rootVal = postorder[end];
    for(int i = start; i < end; i++) {
        if(middleFlag && postorder[i] > rootVal) {
            middle = i;
            middleFlag = false;
        } else if(!middleFlag) {
            if(postorder[i] < rootVal) return false;
        }
    }
    if(middle == start) return recur(postorder, middle, end - 1);
    else if(middle == end) return recur(postorder, start, middle - 1);
    else return recur(postorder, start, middle - 1) && recur(postorder, middle, end - 1);
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
public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if(root == null) return new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> stack = new LinkedList<>();
    recur(root, result, stack, 0, sum);
    return result;
}

public void recur(TreeNode root, List<List<Integer>> result, Deque<Integer> stack, int currentSum, int sum) {
    stack.push(root.val);
    currentSum += root.val;
    if(root.left == null && root.right == null && currentSum == sum)  addToResult(result, stack);
    if(root.left != null) recur(root.left, result, stack, currentSum, sum);
    if(root.right != null) recur(root.right, result, stack, currentSum, sum);
    stack.pop();
}

public void addToResult(List<List<Integer>> result, Deque<Integer> stack) {
    List<Integer> tempList = new ArrayList<>();
    Iterator<Integer> iterator = stack.descendingIterator();
    while(iterator.hasNext())
         tempList.add(iterator.next());
    result.add(tempList);
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
  - 让当前节点的next指向新建的节点
  - 当前指针后移
  - **注意**：在`Node current = head;`中，current是head的引用（指针，更容易理解）
    - 所以`current = current.next;`操作并不会影响head（指针移动）
    - 而`current.next = nodeCopy;`操作会影响head（改变指针所指位置的值）
- 第二步，将原链表中每个节点后面节点的random指向这个节点的random的后面节点
  - next节点指向当前节点的下一个节点
  - 如果当前节点的random指针不为空
    - next的random指向当前节点的random的下一个节点
  - 当前指针指向next的下一个节点（后移）
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
  - 上一个节点：中序遍历保证了节点值由小到大，所以当前节点左子树中最后一个节点也是链表中当前节点的上一个节点
    - last初值为空
- 边界条件：
  - 当前节点无左右子树
- 前进段：
  - 如果当前节点有左子树
    - 递归调用左子树
  - 当前节点的left等于last
  - 如果last非空
    - last的right等于当前节点
  - last等于当前节点
  - 如果当前节点有右子树
    - 递归调用右子树
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

### 面试题39：数组中出现次数超过一半的数字

#### [题目](https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如，输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。

- 思路1：先排序再遍历
  - 时间复杂度O(nlogn) + O(n)
- 思路2：利用快排中的split数组思想
- 思路3：摩尔投票法
  - 第一个数开始，count默认为1
    - 如果下一个数相同，count+1
    - 如果下一个数不同，count-1
  - 如果count为0，则从下一个数开始，count重置为1
  - 最后一次设为1的数一定为目标数

##### 思路2

- 参数
  - start、middle（固定为数组长度的一半）、end、index
- 初始条件
  - start等于0，end等于数组长度-1
  - index等于partition(start, end)结果
- 循环体内（while循环，index不等于middle）
  - 如果index大于middle
    - index等于partition(start, index - 1)
  - 如果index小于middle
    - index指向partition(index + 1, end)

##### 思路3

- 参数
  - count、result
- 初始条件
  - count等于1，result等于nums[0]
- 循环体内（for循环，从1到length-1）
  - 如果count等于0
    - result置为当前位置元素
    - count重置为1
  - 如果count不等于0
    - 如果当前位置元素不等于result
      - count--
    - 如果当前位置元素等于result
      - count++

##### 特殊输入

- 数组为空或数组长度为0
- 数组中间的数字重复次数不到一半

##### 核心代码

```java
	public static int majorityElement(int[] nums) {
		if(!isValidArray(nums))
			return -1;
		int count = 1;
		int result = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(count == 0) {
				result = nums[i];
				count = 1;
			} else
				if(nums[i] != result)
					count--;
				else
					count++;
		}
		if(!isMoreThanHalf(nums, result))
			return -1;
		return result;
	}
	
	public static int majorityElementBySplit(int[] nums) {
		if(!isValidArray(nums))
			return -1;
		int middle = nums.length >> 1;
		int start = 0;
		int end = nums.length - 1;
		int index = QuickSort.split(nums, start, end);
		while(index != middle)
			if(index > middle) {
				end = index - 1;
				index = QuickSort.split(nums, start, end);
			} else {
				start = index + 1;
				index = QuickSort.split(nums, start, end);
			}
		if(!isMoreThanHalf(nums, nums[index]))
			return -1;
		return nums[index];
	}
	
	public static boolean isValidArray(int[] nums) {
		if(nums == null || nums.length == 0)
			return false;
		return true;
	}
	
	public static boolean isMoreThanHalf(int[] nums, int target) {
		int count = 0;
		for(int i : nums)
			if(i == target)
				count++;
		if((count << 1) > nums.length)
			return true;
		return false;
	}
```

### 面试40：最小的k个数

#### [题目](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

输入整数数组 n ，找出其中最小的 k个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

- 思路1：直接遍历数组，统计数字出现的次数（适用于数字可能很少的情况）
  - 时间复杂度O(n)
- 思路2：排序，然后遍历
  - 时间复杂度O(nlogn)
- 思路3：利用快排的partition思想（前提是输入的数组可改变，且k个数未必是排序的）
  - 时间复杂度O(logn)
- 思路4：利用辅助容器（优先级队列、堆、红黑树），实际treeMap好用
  - 时间复杂度O(nlogk)

##### 思路3

- 参数
  - start、end、index
- 初始条件
  - start等于0，end等于数组长度-1
  - index等于partition(start, end)结果
- 循环体内（while循环，index不等于k-1）
  - 如果index大于k-1
    - index等于partition(start, index - 1)
  - 如果index小于k-1
    - index指向partition(index + 1, end)

##### 思路4

- 参数
  - i
- 初始条件
  - i等于0，result等于nums[0]
- 循环体内（for循环，从0到length-1）
  - 如果i<k
    - `treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);`
  - 如果i大于等于k
    - 如果当前位置元素小于treeMap中最大元素（存在key中）
      - `treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);`
      - 如果最大元素对应的value等于1
        - 移除最大元素
      - 如果最大元素对应的value不等于1
        - 则把最大愿随对应的value减1

##### 特殊输入

- 数组为空或数组长度为0

##### 核心代码

```java
	public static int[] getLeastNumbers(int[] arr, int k) {
		if(arr == null)
			return null;
		if(arr.length == 0 || k <=0)
			return new int[0];
		if(k > arr.length)
			return arr;
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for(int i = 0; i < arr.length; i++) {
			if(i < k)
				treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
			else {
				Map.Entry<Integer, Integer> lastEntry = treeMap.lastEntry();
				if(arr[i] < lastEntry.getKey()) {
					treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
					if(lastEntry.getValue() == 1)
						treeMap.pollLastEntry();
					else
						treeMap.put(lastEntry.getKey(), lastEntry.getValue() - 1);
				}
			}
		}
		int[] result = new int[k];
		int i = 0;
		for(Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
			for(int j = 0; j < entry.getValue(); j++)
				result[i++] = entry.getKey();
		}
		return result;
	}
	
	public static int[] getLeastNumbersBySplit(int[] arr, int k) {
		if(arr == null)
			return null;
		if(arr.length == 0 || k <=0)
			return new int[0];
		if(k > arr.length)
			return arr;
		int start = 0;
		int end = arr.length - 1;
		int middle = QuickSort.split(arr, start, end);
        while(middle + 1 != k) {
        	if(middle + 1> k) {
        		end = middle - 1;
        		middle = QuickSort.split(arr, start, end);
        	} else {
        		start = middle + 1;
        		middle = QuickSort.split(arr, start, end);
        	}
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++)
        	result[i] = arr[i];
        return result;
	}
```

























