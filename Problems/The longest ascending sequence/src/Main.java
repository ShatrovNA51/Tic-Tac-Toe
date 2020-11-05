import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int previous = array[0];
        int count = 1;
        int maxCount = 1;
        for (int i : array) {
            if (i > previous) {
                count++;
            } else {
                count = 1;
            }
            previous = i;
            if (count > maxCount) {
                maxCount = count;
            }
        }
        System.out.println(maxCount);
    }
}