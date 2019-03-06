package test;

import java.util.Scanner;

public class CalcV2 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        for (char ch = 0; ch != 'e';) {

            ch = getChoice();  //ch==choice
            if (ch == 'a') {        //a == arab
                System.out.println("Введите выражение:");
                double num1 = getDouble();
                char operation = getOperation();
                double num2 = getDouble();
                double result = calc(num1, operation, num2);
                System.out.println(+result);
            }else if (ch == 'r') {        //r == rom
                System.out.println("Введите выражение:");
                double num1 = getLetToNumb();
                char operation = getOperation();
                double num2 = getLetToNumb();
                double result = calc(num1, operation, num2);
                System.out.println(+result);
            }else {
                System.out.println("Введены неподходящие данные, попробуйте еще раз!!!");
            }
        }
    }

    private static char getOperation() {
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

    private static char getChoice() {
        System.out.println("Выберите тип используемых даных: Арабские(а) или Римские(r)");
        System.out.println("Выход (е)");
        char ch;
        if (scanner.hasNext()) {
            ch = scanner.next().charAt(0);
        } else {
            System.out.println("Введены неподходящие данные, попробуйте еще раз!!!");
            scanner.next();
            ch = getChoice();
        }
        return ch;
    }

    private static double getDouble() {
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

    private static double getLetToNumb() {
        String numb = getRomanian();
        double num;
        switch (numb) {
            case "I": num = 1; break;
            case "II": num = 2; break;
            case "III": num = 3; break;
            case "IV": num = 4; break;
            case "V": num = 5; break;
            case "VI": num = 6; break;
            case "VII": num = 7; break;
            case "VIII": num = 8; break;
            case "IX": num = 9; break;
            case "X": num = 10; break;
            default: num = 0;
        }
        return num;
    }

    private static double calc(double num1, char operation, double num2) {
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

    private static String getRomanian() {
        String numb;
        if (scanner.hasNext()) {
            numb = scanner.next();
        } else {
            System.out.println("Введены неподходящие данные, попробуйте еще раз!!! romanian ");
            scanner.next();
            numb = getRomanian();
        }
        return numb;
    }
}
