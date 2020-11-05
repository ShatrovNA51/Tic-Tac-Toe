import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean a = false;
        if (scanner.nextInt() < 10) {
            a = true;
        }
        System.out.println(a);
    }
}