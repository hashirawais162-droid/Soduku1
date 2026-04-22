import java.io.File;
import java.util.Scanner;
import java.util.HashSet;

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


public boolean isValid() {

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            char c = board[i][j];

            if (!(c == '.' || (c >= '1' && c <= '9'))) {
                return false;
            }
        }
    }

    for (int i = 0; i < 9; i++) {
        HashSet<Character> set = new HashSet<>();

        for (int j = 0; j < 9; j++) {
            char c = board[i][j];

            if (c != '.') {
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
    }

    for (int j = 0; j < 9; j++) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            char c = board[i][j];

            if (c != '.') {
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
    }

    for (int row = 0; row < 9; row += 3) {
        for (int col = 0; col < 9; col += 3) {

            HashSet<Character> set = new HashSet<>();

            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {

                    char c = board[i][j];

                    if (c != '.') {
                        if (set.contains(c)) {
                            return false;
                        }
                        set.add(c);
                    }
                }
            }
        }
    }

    return true;
  }
}
