import java.util.Scanner;

public class NQueens {

    static int N;

    // Print the chessboard
    static void printBoard(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check whether Queen can be placed safely
    static boolean isSafe(int board[][], int row, int col) {

        // Check left side of the row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // Check upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check lower diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Solve N-Queens using Backtracking
    static boolean solveNQueens(int board[][], int col) {

        if (col >= N)
            return true;

        for (int row = 0; row < N; row++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 1;

                if (solveNQueens(board, col + 1))
                    return true;

                // Backtracking
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        N = sc.nextInt();

        int board[][] = new int[N][N];

        // Place first Queen
        board[0][0] = 1;

        System.out.println("Initial Board:");
        printBoard(board);

        // Place remaining Queens
        if (solveNQueens(board, 1)) {

            System.out.println("Final N-Queens Matrix:");
            printBoard(board);

        } else {
            System.out.println("Solution does not exist.");
        }

        sc.close();
    }
}