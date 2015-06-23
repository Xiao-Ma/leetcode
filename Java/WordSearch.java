/**
 * @author Xiao
 * LeetCode: Word Search
 * Description: Given a 2D board and a word, find if the word exists in the 
 *              grid. The word can be constructed from letters of sequential
 *              adjacent cell, where "adjacent" cells are those horizontally or
 *              vertically neighboring. The same letter cell may not be used
 *              more than once.
 * Idea: backtracking
 */
 
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] searched = new boolean[board.length][board[0].length];
        int[] cur = {0,0};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    cur[0] = i;
                    cur[1] = j;
                    searched[i][j] = true;
                    if (search(board, searched, word, cur, 1)) {
                        return true;
                    } else {
                        searched[i][j] = false; //import to reset searched path back to false
                        continue;
                    }
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board, boolean[][] searched, String s, int[] pos, int n) {
        if (n == s.length()) {
            return true;
        }
        char c = s.charAt(n);
        if (pos[0] - 1 >= 0 && board[pos[0] - 1][pos[1]] == c && !searched[pos[0] - 1][pos[1]]) {
            pos[0] -= 1;
            searched[pos[0]][pos[1]] = true;
            if (search(board, searched, s, pos, n+1)) {
                return true;
            }
            searched[pos[0]][pos[1]] = false; 
            pos[0] += 1; //important to reset searched path to false and the current postion
        }
        if (pos[0] + 1 < board.length && board[pos[0] + 1][pos[1]] == c && !searched[pos[0] + 1][pos[1]]) {
            pos[0] += 1;
            searched[pos[0]][pos[1]] = true;
            if (search(board, searched, s, pos, n+1)) {
                return true;
            }
            searched[pos[0]][pos[1]] = false;
            pos[0] -= 1;
        }
        if (pos[1] - 1 >= 0 && board[pos[0]][pos[1] - 1] == c && !searched[pos[0]][pos[1] - 1]) {
            pos[1] -= 1;
            searched[pos[0]][pos[1]] = true;
            if (search(board, searched, s, pos, n+1)) {
                return true;
            }
            searched[pos[0]][pos[1]] = false;
            pos[1] += 1;
        }
        if (pos[1] + 1 <board[0].length && board[pos[0]][pos[1] + 1] == c && !searched[pos[0]][pos[1] + 1]) {
            pos[1] +=1;
            searched[pos[0]][pos[1]] = true;
            if (search(board, searched, s, pos, n+1)) {
                return true;
            }
            searched[pos[0]][pos[1]] = false;
            pos[1] -= 1;
        }
        return false;
    }
}