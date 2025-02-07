package matrix.traversal.pattern;

public class MatrixTraversal {
    /**
     * TODO
     * flood-fill
     * number-of-islands
     */

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
