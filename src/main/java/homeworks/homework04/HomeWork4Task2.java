package homeworks.homework04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork4Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку в которой выполнить поиск стрел");
        String str = scanner.nextLine();
        if (str.length() > 106) {
            System.out.println("Неверный ввод. Строка может содержать не более 106 символов. Операция прервана");
            System.exit(1);
        }
        Pattern pattern = Pattern.compile(">>-->|<--<<");
        Matcher matcher = pattern.matcher(str);
        int arrow = 0;
        while (matcher.find()) {
            arrow++;
        };
        System.out.println("Количество стрел: " + arrow);
    }
}
