package Question12;

// https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		char[][] board = {{'a', 'b', 't', 'g'},
						  {'c', 'f', 'c', 's'},
						  {'j', 'd', 'e', 'h'}};
		String word = "bfce";
		// board = new char[0][0];
		// word = "";
		System.out.println(exist(board, word));
	}
	
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
		if(word.charAt(index) != board[i][j] || isVisited[i][j])
			return false;
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
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
}
