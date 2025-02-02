package homeworks.homework11;


import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<Car>();
        Scanner scanner = new Scanner(System.in);

        String strCar = "";
        System.out.println("Введите автомобиль");
        while (!strCar.equals("END")) {
            strCar = scanner.nextLine();
            if (strCar.equals("END")) {
                break;
            };
            String [] carParametr =  strCar.split("\\|");
            String number = carParametr[0].trim();
            String model = carParametr[1].trim();
            String color = carParametr[2].trim();
            Integer mileage = Integer.parseInt(carParametr[3].trim());
            Integer price = Integer.parseInt(carParametr[4].trim());
            carList.add(new Car(number, model, color, mileage, price));
        }


        System.out.println("Автомобили в базе:");
        System.out.println("Number Model Color Mileage Cost");
        for (Car car : carList) {
            System.out.println(car.getNumber() + " " + car.getModel() + " " + car.getColor() + " " + car.getMileage() + " " + car.getPrice());
        }

        String colorToFind = "Black";
        Integer mileageToFind = 0;
        StringJoiner stringJoiner = new StringJoiner(" ");
        carList.stream()
                .filter(car -> car.getColor().equals(colorToFind) || car.getMileage().equals(mileageToFind))
                .forEach(car -> stringJoiner.add(car.getNumber()));
        System.out.println("Номера автомобилей по цвету или пробегу: " + stringJoiner);

        Integer n = 700000;
        Integer m = 800000;
        Long uniqueCar;
        uniqueCar = carList.stream()
                .filter(car -> car.getPrice() >= n && car.getPrice() <= m)
                .distinct()
                .count();
        System.out.println("Уникальные автомобили: " + uniqueCar);


        carList.stream()
                .sorted(Comparator.comparing(car -> car.getPrice()))
                .limit(1)
                .forEach(car ->System.out.println("Цвет автомобиля с минимальной стоимостью: " + car.getColor()));

        String modelToFind = "Toyota";
        OptionalDouble aver = carList.stream()
                .filter(car -> car.getModel().equals(modelToFind))
                .mapToInt(car ->car.getPrice())
                .average();
        System.out.println("Средняя цена автомобиля " + modelToFind + " : " + aver.orElse(0));


        String modelToFind2 = "Volvo";
        aver = carList.stream()
                .filter(car -> car.getModel().equals(modelToFind2))
                .mapToInt(car ->car.getPrice())
                .average();
        System.out.println("Средняя цена автомобиля " + modelToFind2 + " : " + aver.orElse(0));
    }

}
