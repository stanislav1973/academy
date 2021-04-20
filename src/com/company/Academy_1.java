package com.company;
import java.util.*;
public class Academy_1 {
    public static int sumInRange(int from, int to) {
        int result = 0;
        int range = to - from;
        for (int i = 0; i < range; i++) {
            result = (from + i) + result;
        }
        return result;
    }

    public void calculation() {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        char ch = scanner.next().charAt(0);
        long number1 = scanner.nextLong();

        long result;
        switch (ch) {
            case '+':
                result = number + number1;
                System.out.print(result);
                break;
            case '*':
                result = number * number1;
                System.out.print(result);
                break;
            case '/':
                try {
                    if (number1 == 0) {
                        System.out.print("Division by 0!");
                        break;
                    }
                } catch (ArithmeticException e) {

                }
                result = number / number1;
                System.out.println(result);
                break;
            case '-':
                result = number - number1;
                System.out.print(result);
                break;
            default:
                System.out.print("Unknown operator");
        }
    }
    public static void subtractTwoNumbers(long a,long b){
        if(b == 0){
            System.out.print("Division by 0!");
        }
        else System.out.print(a/b);
    }
}

