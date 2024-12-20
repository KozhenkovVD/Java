package homeworks.homework02;

import java.util.Scanner;
public class HomeWork2Task4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число строк и столбцов сетки:");
        int count = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите повторяемый элемент сетки:");
        String symbol = scanner1.nextLine();

        String strnew = "";
        int i = 0;
        while (i < count){
            strnew = strnew + symbol;
            i++;
        }

        int y = 0;
        while (y < count){
            System.out.println(strnew);
            y++;
        }
    }
}