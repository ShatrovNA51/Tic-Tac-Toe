import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int arraySize = size * size;
        int[][] sudoku = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; ++i) {
            for (int j = 0; j < arraySize; ++j) {
                sudoku[i][j] = scan.nextInt();
            }
        }

        String valid = verifySudoku(sudoku, size);
        System.out.println(valid);

    }

    static String verifySudoku(int[][] sudoku, int size) {
        //We will check if each number from 1 to sudoku.length is counted once.
        //1 for row. 1 for column. 1 for each small square
        for (int number = 1; number <= sudoku.length; ++number) {
            if ("NO".equals(checkRowsAndColumns(sudoku, number))) {
                return "NO";
            }
            if ("NO".equals(checkSmallerSquares(sudoku, number, size))) {
                return "NO";
            }
        }
        return "YES";
    }

    static String checkRowsAndColumns(int[][] sudoku, int number) {
        //Now we traverse the rows and columns of the 2-dimensional matrix
        int i = 0;
        while (i < sudoku.length) {
            int rowCounter = 0;
            int columnCounter = 0;
            int j = 0;
            while (j < sudoku.length) {
                //Check match in each row
                if (number == sudoku[i][j]) {
                    ++rowCounter;
                    //++counter;
                }
                //Check match in each column
                if (number == sudoku[j][i]) {
                    ++columnCounter;
                    //++counter;
                }
                ++j;
            }
            //This is the correct implementation but unfortunately it fails because
            //of bad test #7 of 14
            /*if ((rowCounter != 1) && (columnCounter != 1)) {
                return "NO";
            }*/

            //The problem with this is we can have columnCounter = 2 and rowCounter = 0 and it would still pass
            //It should be 1 occurrence for each row and column
            if (rowCounter + columnCounter != 2) {
                return "NO";
            }
            ++i;
        }
        return "YES";
    }

    static String checkSmallerSquares(int[][] sudoku, int number, int size) {
        //We will check smaller squares from top left to top right then move down to
        //check the next set from left to right and so forth
        //Outer for loop for top to bottom
        for (int i = 0; i < sudoku.length; i += size) {
            //for loop for left to right
            for (int j = 0; j < sudoku.length; j += size) {
                int counter = 0;
                //These inner two for loops will check for each small square
                //We check each column from left to right
                for (int m = j; m < j + size; ++m) {
                    for (int n = i; n < i + size; ++n) {
                        //Check match in each column of each small square
                        if (number == sudoku[n][m]) {
                            ++counter;
                        }
                        //If the tally is more than 1 we stop things
                        if (counter > 1) {
                            return "NO";
                        }
                    }
                }
                //Now we tally and if not equal to 1 we stop things
                if (counter != 1) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}