package back.tracking;

public class BackTrackingAlgo {

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
