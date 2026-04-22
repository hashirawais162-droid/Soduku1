import java.io.File;
import java.util.Scanner;

public class SudokuBoard {

    private char[][] board;

    // Constructor
    public SudokuBoard(String fileName) {
        board = new char[9][9];

        try {
            Scanner input = new Scanner(new File(fileName));

            for (int i = 0; i < 9; i++) {
                String line = input.nextLine();

                for (int j = 0; j < 9; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            input.close();

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }

    // toString method
    public String toString() {
        String result = "";

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result += board[i][j] + " ";
            }
            result += "\n";
        }

        return result;
    }
}