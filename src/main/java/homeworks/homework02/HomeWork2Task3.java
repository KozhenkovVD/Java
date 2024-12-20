package homeworks.homework02;

import java.util.Scanner;

public class HomeWork2Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Исходная строка:");
        String str = scanner.nextLine();
        System.out.println("Сколько раз вывести строку?");
        int count = scanner.nextInt();
        int i = 0;
        String strnew = "";
        while (i < count){
            strnew = strnew + str;
            i++;
        }
        System.out.println("После повторения " + count + " раз: " + strnew);

    }
}