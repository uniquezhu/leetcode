public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int width = board[0].length;
        int height = board.length;

        int[][] flag = new int[height][width];
        for (int i = 0; i < width; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board, flag);
            }
            if (board[height - 1][i] == 'O') {
                dfs(height -1, i, board, flag);
            }
        }

        for (int i = 0; i < height; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board, flag);
            }
            if (board[i][width - 1] == 'O') {
                dfs(i, width -1, board, flag);
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O' && flag[i][j] != -1) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // X: 1; O: -1
    private void dfs(int x, int y, char[][] board, int[][] flag) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (flag[x][y] != 0) {
            return;
        }
        if (board[x][y] == 'X') {
            flag[x][y] = 1;
            return;
        }

        flag[x][y] = -1;
        dfs(x-1, y, board, flag);
        dfs(x+1, y, board, flag);
        dfs(x, y-1, board, flag);
        dfs(x, y+1, board, flag);
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
        };

        Solution solution = new Solution();
        solution.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
