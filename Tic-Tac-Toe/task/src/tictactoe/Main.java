package tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] field = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        fillField(field);
        printField(field);
        char side = 'X';
        do  {
            input(field, side, scanner);
            printField(field);
            if (side == 'X') {
                side = 'O';
            } else {
                side = 'X';
            }
        }
        while (!checkResult(field));
    }

    public static void fillField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = ' ';
            }
        }
    }

    public static void fillField(char[][] field, Scanner scanner) {
        System.out.print("Enter cells: ");
        String s = scanner.next();
        for (int i = 0; i < field.length; i++) {
            field[i] = s.substring(i * 3, (i + 1) * 3).toCharArray();
        }
    }

    public static void printField(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < field.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean isEmptyCells (char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if ('X' != field[i][j] || field[i][j] != 'O') {
                    return true;
                }
            }
        }
        return false;
    }

    public static int countThreeInRow(char[][] field, char element) {
        int counter = 0;
        for (int i = 0; i < field.length; i++) {
            boolean isRow = true;
            boolean isColumn = true;
            for (int j = 0; j < field.length; j++) {
                if (element != field[i][j]) {
                    isRow = false;
                }
                if (element != field[j][i]) {
                    isColumn = false;
                }
            }
            if (isRow) {
                counter++;
                if (counter > 1) {
                    return counter;
                }
            }
            if (isColumn) {
                counter++;
                if (counter > 1) {
                    return counter;
                }
            }
        }

        //Проверка диагоналей
        boolean mainDiagonal = true;
        boolean sideDiagonal = true;
        for (int i = 0; i < field.length; i++) {
            if (element != field[i][i]) {
                mainDiagonal = false;
            }
            if (element != field[i][field.length - 1 - i]) {
                sideDiagonal = false;
            }
        }
        if (mainDiagonal) {
            counter++;
        }
        if (sideDiagonal) {
            counter++;
        }

        return counter;
    }

    public static int countElement(char[][] field, char element) {
        int counter = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (element == field[i][j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void input (char[][] field, char side, Scanner scanner) {
        boolean isRightInput = false;
        while (!isRightInput) {
            System.out.print("Enter the coordinates:");
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if ((x < 1 || x > 3) || (y < 1 || y > 3)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (field[3 - y][x - 1] == 'X' || field[3 - y][x - 1] == 'O' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                } else {
                    field[3 - y][x - 1] = side;
                    isRightInput = true;
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("You should enter numbers!");
            }
        }
    }

    public static boolean checkResult(char[][] field) {
        boolean hasEmptyCell = isEmptyCells(field);
        int sumThreeInRowX = countThreeInRow(field, 'X');
        int sumThreeInRowO = countThreeInRow(field, 'O');
        int countX = countElement(field, 'X');
        int countO = countElement(field, 'O');
        if (Math.abs(countO - countX) > 1 || (sumThreeInRowO > 0 && sumThreeInRowX > 0)) {
            System.out.println("Impossible");
            return true;
        } else if (sumThreeInRowO == 0 && sumThreeInRowX == 0 && !hasEmptyCell) {
            System.out.println("Draw");
            return true;
        } else if (sumThreeInRowO == 1) {
            System.out.println("O wins");
            return true;
        } else if (sumThreeInRowX == 1) {
            System.out.println("X wins");
            return true;
        } /*else if (hasEmptyCell) {
            System.out.println("Game not finished");
        }*/
        return false;
    }
}
