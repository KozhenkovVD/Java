package homeworks.homework02;

import java.util.Scanner;


public class HomeWork2Task1 {
    public static void main(String[] args) {
        System.out.println("Введите степень в градусах Фаренгейта:");
        Scanner scanner = new Scanner(System.in);
        Double  tempF = scanner.nextDouble();
        Double  tempeC = (tempF - 32) * 5/9;
        System.out.println(tempF + " градусов по Фаренгейту равна " + tempeC + " по Цельсию");
    }
}

