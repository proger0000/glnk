import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double num1 = getDouble();
        char operation = getOperation();
        double num2 = getDouble();
        double result = calc(num1, operation, num2);
        System.out.println(+ result);
    }


    public static double getDouble() {
        System.out.print("Введите число:");
        double num;
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
        } else {
            System.out.println("Введены неподходящие данные, попробуйте еще раз!!!");
            scanner.next();
            num = getDouble();
        }
        return num;
    }

    public static char getOperation() {
        System.out.print("Введите операцию:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Введены неподходящие данные, попробуйте еще раз!!!");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static double calc(double num1, char operation, double num2) {
        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Введена неподходящая операция, попробуйте еще раз!!!");
                result = calc(num1, getOperation(), num2);
        }
        return result;
    }
}
