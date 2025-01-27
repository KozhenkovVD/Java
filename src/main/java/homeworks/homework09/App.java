package homeworks.homework09;

import homeworks.homework09.car.Car;
import homeworks.homework09.car.PerformanceCar;
import homeworks.homework09.car.ShowCar;
import homeworks.homework09.race.CasualRace;
import homeworks.homework09.race.DragRace;
import homeworks.homework09.race.DriftRace;
import homeworks.homework09.race.Race;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Garage garage = new Garage();
        List<Race> raceList = new ArrayList<Race>();
        garage.AddCarToGarage(new ShowCar("BMW", "5", 2020, 200, 7, 100, 10));
        garage.AddCarToGarage(new PerformanceCar("AUDI", "A5", 210, 250, 10, 150, 10));
        garage.AddCarToGarage(new Car("Porsche", "911", 1980, 200, 5, 80, 5));
        System.out.println(garage.GetCarFromGarage());

        garage.AddModification("AUDI", "A5", "Шины");
        garage.RemoveCarFromGarage("Porsche", "911");
        System.out.println(garage.GetCarFromGarage());




        raceList.add(new CasualRace(100, "Rome", 10000));
        raceList.add(new DragRace(1, "Moscow", 1000));
        raceList.add(new DriftRace(10, "Tokyo", 100));

        for (Race i : raceList){
            System.out.println(i);
            }



    }
}
