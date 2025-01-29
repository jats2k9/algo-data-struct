package depth.first;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSeach {

    /**
     * https://leetcode.com/problems/path-sum/
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        dfs(paths, path, root, targetSum);

        return paths;
    }

    private void dfs(List<List<Integer>> paths, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        path.add(root.val);

        if (root.right == null && root.left == null && targetSum == 0) {
            paths.add(new ArrayList<>(path));
        }
        dfs(paths, path, root.right, targetSum);
        dfs(paths, path, root.left, targetSum);
        path.removeLast();
    }

    boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        boolean leftSum = hasPathSum(root.left, targetSum - root.val);
        boolean rightSum = hasPathSum(root.right, targetSum - root.val);
        return leftSum || rightSum;
    }


    /**
     * https://leetcode.com/problems/surrounded-regions/
     */

    void surroundedRegions(char[][] board) {
        int lastRow = board.length - 1;
        int lastCol = board[0].length - 1;

        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == 'O') {
                findAdjacent(board, 0, c);
            }
            if (board[lastRow][c] == 'O') {
                findAdjacent(board, lastRow, c);
            }
        }
        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == 'O') {
                findAdjacent(board, r, 0);
            }
            if (board[r][lastCol] == 'O') {
                findAdjacent(board, r, lastCol);
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == '*') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void findAdjacent(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
        else if (grid[r][c] == 'X') return;
        else if (grid[r][c] == '*') return;
        else if (grid[r][c] == 'O') grid[r][c] = '*';

        findAdjacent(grid, r - 1, c);
        findAdjacent(grid, r + 1, c);
        findAdjacent(grid, r, c - 1);
        findAdjacent(grid, r, c + 1);
    }

}

