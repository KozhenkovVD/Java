package homeworks.homework02;

import java.util.Scanner;

public class HomeWork2Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1-е целое число:");
        int num1 = scanner.nextInt();
        System.out.println("Введите второе целое число:");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;
        int raznica = num1 - num2;
        int proizvedenie = num1 * num2;
        double srednee = (num1 + num2) / 2;
        int rasstoyanie = Math.abs(num1 - num2);
        int max = Math.max(num1,num2);
        int min = Math.min(num1,num2);

        System.out.println("Сумма двух целых чисел: " + sum);
        System.out.println("Разница двух целых чисел: " + raznica);
        System.out.println("Произведение из двух целых чисел: " + proizvedenie);
        System.out.println("Среднее из двух целых чисел: " + srednee);
        System.out.println("Расстояние двух целых чисел: " + rasstoyanie);
        System.out.println("Максимальное целое число: " + max);
        System.out.println("Минимальное целое число: " + min);

    }
}

