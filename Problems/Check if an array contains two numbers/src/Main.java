import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean isNumberNextToEachOther = false;
        for (int i = 0; i < size; i++) {
            if (array[i] == n) {
                if (i + 1 < size && array[i + 1] == m) {
                    isNumberNextToEachOther = true;
                    break;
                }
            }
            if (array[i] == m) {
                if (i + 1 < size && array[i + 1] == n) {
                    isNumberNextToEachOther = true;
                    break;
                }
            }
        }
        System.out.println(isNumberNextToEachOther);
    }
}