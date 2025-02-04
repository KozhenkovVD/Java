package homeworks.homework11Addition.test;


import homeworks.homework11Addition.model.Car;
import homeworks.homework11Addition.repository.CarsRepository;
import homeworks.homework11Addition.repository.CarsRepositoryImpl;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        CarsRepository repository = new CarsRepositoryImpl();

        try {
            FileReader fileReader = new FileReader("src/main/java/homeworks/homework11Addition/data/cars.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("src/main/java/homeworks/homework11Addition/data/result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            while (bufferedReader.ready()) {
                String[] carParameters = bufferedReader.readLine().split("\\|");
                String number = carParameters[0].trim();
                String model = carParameters[1].trim();
                String color = carParameters[2].trim();
                Integer mileage = Integer.parseInt(carParameters[3].trim());
                Integer price = Integer.parseInt(carParameters[4].trim());
                repository.addCarToRepository(new Car(number, model, color, mileage, price));
            }

            bufferedWriter.write("Автомобили в базе:" + "\r");
            bufferedWriter.write("Number Model Color Mileage Cost" + "\r");
            List<Car> carList = repository.getCarFromRepository();
            for (Car i : carList) {
                bufferedWriter.write(i.getNumber() + " " + i.getModel() + " " + i.getColor() + " " + i.getMileage() + " " + i.getPrice()+ "\r");
            }

            bufferedWriter.write(repository.findNumberFromColorAndMileage("Black", 0) + "\r");
            bufferedWriter.write(repository.findCountCarFromPrice(700000,800000) + "\r");
            bufferedWriter.write(repository.findColorFromMinPrice() + "\r");
            bufferedWriter.write(repository.findAvgPriceFromModel("Toyota") + "\r");
            bufferedWriter.write(repository.findAvgPriceFromModel("Volvo") + "\r");

            bufferedWriter.flush();
            fileReader.close();
            fileWriter.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
