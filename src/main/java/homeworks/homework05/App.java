package homeworks.homework05;

import java.util.*;

public class App {

    public static void main(String[] args) {


        Scanner scanner1 = new Scanner(System.in);
        Television[] televisions = new Television[10];
        televisions[0] = new Television("LG", 90, true);
        televisions[1] = new Television("Samsung", 2, true);
        televisions[2] = new Television("Hisense", 4, true);
        televisions[3] = new Television("Sony", 7, false);
        televisions[4] = new Television("Panasonic", 6, true);
        televisions[5] = new Television("Philips", 9, false);
        televisions[6] = new Television("TCL", 45, true);
        televisions[7] = new Television("Xiaomi", 8, true);
        televisions[8] = new Television("Haier", 15, true);
        televisions[9] = new Television("Яндекс", 10, true);

        ArrayList<Chanel> chanelArrayList = new ArrayList<Chanel>();
        chanelArrayList.add(new Chanel("Первый канал", 1));
        chanelArrayList.add(new Chanel("Россия", 2));
        chanelArrayList.add(new Chanel("MTV", 10));
        chanelArrayList.add(new Chanel("РЕНТВ", 15));

        ArrayList<Program> programArrayList = new ArrayList<Program>();
        programArrayList.add(new Program("Новости", 80, 5000));
        programArrayList.add(new Program("В мире животных", 50, 1000));
        programArrayList.add(new Program("Камеди", 10, 10000));


        for (Television str1 : televisions) {
            str1.setChanel(chanelArrayList.get(0));
        }

        System.out.println("Выберете телевизор? (Производитель)");
        String strProducerTV = scanner1.nextLine();
        for (Television str1 : televisions) {
            if (str1.getProducer().equals(strProducerTV)) {
                Television tv = str1;
            }
        }
            System.out.println("Какой включить канал? (номер)");
            Integer numChanel = scanner1.nextInt();
            for (Chanel str2 : chanelArrayList) {
                if (str2.getNumber() == numChanel) {
                    Chanel chanel = str2;

                }
                ;
            }


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

            Comparator<Television> orderByChanel = Comparator.comparing(Television::getChanel);
            Arrays.sort(televisions, orderByChanel);

            Integer maxVolume;
            System.out.println("Введите максимальную громкость (целое число в диапазоне 50-70)");


            do {
                maxVolume = scanner1.nextInt();
                if (maxVolume < 50 || maxVolume > 70) {
                    System.out.println("Введены неверные данные, нужно ввести целое число в диапазоне 50-70. Попробуйте еще");
                }
            } while (maxVolume < 50 || maxVolume > 70);

            for (int i = 0; i < televisions.length; i++) {
                if (televisions[i].getActive() == true && televisions[i].getVolume() <= maxVolume) {
                    System.out.println(televisions[i].toString());
                }
            }
        }
    }

