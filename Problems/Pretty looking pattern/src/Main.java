import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] array = new char[4][4];
        for (int i = 0; i < 4; i++) {
            array[i] = scanner.next().toCharArray();
        }
        boolean plp = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == array[i + 1][j + 1] &&
                        array[i][j]  == array[i][j + 1] &&
                        array[i][j]  == array[i + 1][j]) {
                    plp = false;
                    break;
                }
            }
        }
        System.out.println(plp ? "YES" : "NO");
    }
}