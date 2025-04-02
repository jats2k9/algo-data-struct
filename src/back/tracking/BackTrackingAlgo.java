package back.tracking;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingAlgo {

    public static void main(String[] args) {
        permute(new int[]{1,2,3,4,5});
    }

    /**
     * TODO
     * subsets
     * n-queens
     */

    /**
     * permutations
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, result, temp);
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) {
                    continue;
                }
                temp.add(nums[i]);
                backtrack(nums, result, temp);
                temp.removeLast();
            }
        }
    }

    /**
     * https://leetcode.com/problems/word-search/
     */
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (searchAdjecent(r, c, 0, word, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean searchAdjecent(int r, int c, int index, String word, char[][] board) {
        if (index == word.length())
            return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || word.charAt(index) != board[r][c] || board[r][c] == ' ')
            return false;
        if (board[r][c] == word.charAt(index)) {
            char temp = board[r][c];
            board[r][c] = ' ';
            index++;
            boolean found = searchAdjecent(r - 1, c, index, word, board) ||
                    searchAdjecent(r + 1, c, index, word, board) ||
                    searchAdjecent(r, c - 1, index, word, board) ||
                    searchAdjecent(r, c + 1, index, word, board);

            if (!found) {
                board[r][c] = temp;
            }
            return found;
        } else {
            return false;
        }
    }
}
