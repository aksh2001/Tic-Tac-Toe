import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
        Scanner sc = new Scanner(System.in);
        char player ='X';
        boolean gameOver = false;
        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+ player+" enter row and column:");
            int[] coordinates = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = coordinates[0];
            int col = coordinates[1];
            if(row > 2 || row <0 ){
                System.out.println("Incorrect Coordinates");
                continue;
            }
            if(col > 2 || col <0 ){
                System.out.println("Incorrect Coordinates");
                continue;
            }
            if(board[row][col] == ' ') board[row][col] = player;
            else{
                System.out.println("Wrong input, please try again!");
                continue;
            }
            gameOver = hasWon(board, player);
            if(gameOver)System.out.println("Player "+player+" has won!");
            else player = player == 'X' ? 'O':  'X';
        }
        printBoard(board);
    }

    private static boolean hasWon(char[][] board, char player) {
        // Check Rows
        for (int row = 0; row < board.length; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player) return true;
        }
        //Check Column
        for (int col = 0; col < board.length; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player) return true;
        }
        // Check Diagonals
        return board[0][0] == player && board[1][1] == player && board[2][2] == player;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[col][row]+" | ");
            }
            System.out.println();
        }
    }
}