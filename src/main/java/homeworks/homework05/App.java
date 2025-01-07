package homeworks.homework05;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {


        Scanner scanner1 = new Scanner(System.in);
        Television [] televisions = new Television[10];
        televisions[0] = new Television("LG", 1, 15, true);
        televisions[1] = new Television("Samsung", 2, 80, true);
        televisions[2] = new Television("Hisense", 4, 20, true);
        televisions[3] = new Television("Sony", 7, 90, false);
        televisions[4] = new Television("Panasonic", 6, 29, true);
        televisions[5] = new Television("Philips", 9, 20, false);
        televisions[6] = new Television("TCL", 45, 45, true);
        televisions[7] = new Television("Xiaomi", 8, 20, true);
        televisions[8] = new Television("Haier", 15, 20, true);
        televisions[9] = new Television("Яндекс", 10, 100, true);

//  Ручной ввод данных
//      for (int i = 0; i< televisions.length; i++) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Введите производителя телевизора");
//            String producer = scanner.nextLine();
//            System.out.println("Введите включенный канал");
//            Integer chanel = scanner.nextInt();
//            System.out.println("Введите громкость телевизора");
//            Integer volume = scanner.nextInt();
//            System.out.println("Телевизор включен? (да/нет)");
//            boolean isActive = scanner.nextBoolean();
//            televisions[i] = new Television(producer, chanel, volume, isActive);}

        Comparator <Television> orderByChanel = Comparator.comparing(Television::getChanel);
        Arrays.sort(televisions, orderByChanel);

        for (int i = 0; i< televisions.length; i++) {
            System.out.println(televisions[i].toString());

        }

        Integer channel;
        System.out.println("Введите новый канал телевизора LG");
        channel = scanner1.nextInt();
        televisions[0].changeChanel(channel);



        String isActive;
        System.out.println("Включить или выключить телевизора LG (введите on/off)");
        isActive = scanner1.next();
        televisions[0].TurnOnOff(isActive);




        Integer maxVolume;
        System.out.println("Введите максимальную громкость (целое число в диапазоне 50-70)");




        do {
            maxVolume = scanner1.nextInt();
            if (maxVolume < 50 || maxVolume > 70 ) {
                System.out.println("Введены неверные данные, нужно ввести целое число в диапазоне 50-70. Попробуйте еще");
            }
        } while (maxVolume < 50 || maxVolume > 70 );

        for (int i = 0; i< televisions.length; i++){
            if (televisions[i].getActive() == true && televisions[i].getVolume() <= maxVolume)
            {System.out.println(televisions[i].toString());}
        }

        System.out.println("Новые классы Channel и Program");
        Channel channel1 = new Channel("Первый канал", 1);
        Program program1 = new Program("Новости", 80, 5000);

        System.out.println(channel1);
        System.out.println(program1);

        channel1.changeName("MTV");
        program1.changeRating(10);

        System.out.println(channel1);
        System.out.println(program1);

    }
}
