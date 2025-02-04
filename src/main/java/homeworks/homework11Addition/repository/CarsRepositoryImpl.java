package homeworks.homework11Addition.repository;

import homeworks.homework11Addition.model.Car;

import javax.swing.*;
import java.util.*;

public class CarsRepositoryImpl implements CarsRepository {
    private List<Car> carList = new ArrayList<Car>();

    public void addCar(Car car){
        this.carList.add(car);
    }



    @Override
    public String toString() {
        return "CarsRepositoryImpl{" +
                "carList=" + carList +
                '}';
    }



    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }


    public void  addCarToRepository(Car car){
        this.carList.add(car);
    }

    public String findNumberFromColorAndMileage(String colorToFind, Integer mileageToFind) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        carList.stream()
                .filter(car -> car.getColor().equals(colorToFind) || car.getMileage().equals(mileageToFind))
                .forEach(car -> stringJoiner.add(car.getNumber()));
        //System.out.println("Номера автомобилей по цвету или пробегу: " + stringJoiner);
        return ("Номера автомобилей по цвету или пробегу: " + stringJoiner);
    }


    public String findCountCarFromPrice(Integer n, Integer m) {
        Long uniqueCar;
        uniqueCar = carList.stream()
                .filter(car -> car.getPrice() >= n && car.getPrice() <= m)
                .distinct()
                .count();
        return ("Уникальные автомобили: " + uniqueCar);
    }


    public String findColorFromMinPrice() {
        Car car1 = carList.stream()
                .sorted(Comparator.comparing(car -> car.getPrice()))
                .findFirst()
                //.limit(1)
                .get();
        return ("Цвет автомобиля с минимальной стоимостью: " + car1.getColor());
    }

    public String findAvgPriceFromModel(String modelToFind) {
        OptionalDouble aver = carList.stream()
                .filter(car -> car.getModel().equals(modelToFind))
                .mapToInt(car ->car.getPrice())
                .average();
        return ("Средняя цена автомобиля " + modelToFind + " : " + aver.orElse(0));
    }

    public List<Car> getCarFromRepository() {
        return carList;
    }
}
