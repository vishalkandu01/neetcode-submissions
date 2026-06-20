class Solution {
    private boolean validate(char[][] board, int row, int col) {
        int[] rowHash = new int[9];
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.') {
                int index = board[i][col] - '0' - 1;
                if (rowHash[index] != 0) {
                    return false;
                }
                rowHash[index]++;
            }
        }

        int[] colHash = new int[9];
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.') {
                int index = board[row][i] - '0' - 1;
                if (colHash[index] != 0) {
                    return false;
                }
                colHash[index]++;
            }
        }

        int[] hash = new int[9];
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0' - 1;
                    if (hash[index] != 0) {
                        return false;
                    }
                    hash[index]++;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!validate(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
