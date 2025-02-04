package homeworks.homework11Addition.repository;

import homeworks.homework11Addition.model.Car;

import java.util.List;


public interface CarsRepository {
    <T> List<T> getCarFromRepository();
    void addCarToRepository(Car car);
    String findNumberFromColorAndMileage (String colorToFind, Integer mileageToFind); //1) Номера всех автомобилей, имеющих заданный в переменной цвет colorToFind или нулевой пробег mileageToFind.
    String findCountCarFromPrice (Integer n, Integer m);//2) Количество уникальных моделей в ценовом диапазоне от n до m тыс.
    String findColorFromMinPrice ();  //3) Вывести цвет автомобиля с минимальной стоимостью.
    String findAvgPriceFromModel (String modelToFind); //  4) Среднюю стоимость искомой модели modelToFind


}
