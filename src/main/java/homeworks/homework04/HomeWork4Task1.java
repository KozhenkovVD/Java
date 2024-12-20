package homeworks.homework04;

import java.util.Scanner;

public class HomeWork4Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keybord = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println("Введите маленькую букву английского алфавита");
        String str = scanner.nextLine();

        if (str.matches("[a-z]") == false) {
            System.out.println("Неверный ввод. Операция прервана");
            System.exit(1);
        }

        int position = keybord.lastIndexOf(str);
        int positionLast = keybord.length()-1;
        if (position == 0) {
            System.out.println(keybord.substring(positionLast));
        } else {
            System.out.println(keybord.substring(position - 1, position));
        }

    }
}