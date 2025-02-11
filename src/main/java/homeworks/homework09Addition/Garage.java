package homeworks.homework09Addition;

import homeworks.homework09Addition.car.Car;
import homeworks.homework09Addition.car.PerformanceCar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Garage {
    private List<Car> parkedCars = new ArrayList<Car>();

    public void addCarToGarage(Car car) {
        this.parkedCars.add(car);
    };

    public void removeCarFromGarage (String brand, String model) {
        //parkedCars.remove(1);
        for (Car i : parkedCars) {
            if (i.getBrand().equals(brand) && i.getModel().equals(model)) {
                parkedCars.remove(i);
                break;
            }
        }
    };


//    public List<Car> GetCarFromGarage(){
//        return (this.parkedCars);
//    }
    public String getCarFromGarage() {
        StringJoiner str = new StringJoiner("");
        for (Car i : this.parkedCars) {
            str.add(i + "\r\n");
        }
        return (str.toString());
    }

    public void addModification(String brand, String model, String addon) {
        for (Car i : parkedCars) {
            if (i instanceof PerformanceCar && i.getBrand().equals(brand) && i.getModel().equals(model)) {
                ((PerformanceCar) i).addAddon(addon);
            }
        }
    }



    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + parkedCars +
                '}';
    }
}

