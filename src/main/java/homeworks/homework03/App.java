package homeworks.homework03;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите производителя телевизора № 1");
        String producer = scanner.nextLine();
        System.out.println("Введите модель телевизора № 1");
        String model = scanner.nextLine();
        System.out.println("Введите диагональ телевизора № 1");
        Integer diagonal = scanner.nextInt();
        System.out.println("Введите цену телевизора № 1");
        Float price = scanner.nextFloat();

        Television tv1 = new Television(producer, model, diagonal, price);

        System.out.println("Введите производителя телевизора № 2");
        producer = scanner1.nextLine();
        System.out.println("Введите модель телевизора № 2");
        model = scanner1.nextLine();
        System.out.println("Введите диагональ телевизора № 2");
        diagonal = scanner1.nextInt();
        System.out.println("Введите цену телевизора № 2");
        price = scanner1.nextFloat();

        Television tv2 = new Television(producer, model, diagonal, price);

        System.out.println("Созданы следующие объекты:");
        System.out.println(tv1);
        System.out.println(tv2);

        System.out.println("Введите новую цену телевизора № 2");
        Float priceNew = scanner.nextFloat();

        tv2.setPrice(priceNew);

        System.out.println(tv2);



    }
}

