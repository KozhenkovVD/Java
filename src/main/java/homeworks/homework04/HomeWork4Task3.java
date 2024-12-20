package homeworks.homework04;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork4Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку состоящую из букв английского алфавита разделенных одним пробелом");
        String str = scanner.nextLine();

        if (str.matches("[a-zA-Z]+ [a-zA-Z]+") == false) {
            System.out.println("Неверный ввод. Операция прервана");
            System.exit(1);
        }
        str = str.toLowerCase();

        String [] parts =  str.split(" ");

        char [] part1 = parts[0].toCharArray();
        char [] part2 = parts[1].toCharArray();

        Arrays.sort(part1);
        Arrays.sort(part2);

        String str1 = new  String(part1);
        String str2 = new String(part2);

        System.out.println(str1 + " " + str2);
    }
}
