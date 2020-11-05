import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int begin = scanner.nextInt();
        int end = scanner.nextInt();
        double sum = 0.0;
        int count = 0;
        for (int i = begin; i <= end; i++) {
            if (i % 3 == 0) {
                sum += i;
                ++count;
            }
        }
        System.out.println(sum / count);
    }
}