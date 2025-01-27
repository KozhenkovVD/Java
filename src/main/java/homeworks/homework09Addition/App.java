package homeworks.homework09Addition;

import homeworks.homework09Addition.Garage;
import homeworks.homework09Addition.car.Car;
import homeworks.homework09Addition.car.PerformanceCar;
import homeworks.homework09Addition.car.ShowCar;
import homeworks.homework09Addition.race.CasualRace;
import homeworks.homework09Addition.race.DragRace;
import homeworks.homework09Addition.race.DriftRace;
import homeworks.homework09Addition.race.Race;
import homeworks.homework09Addition.race.CircuitRace;
import homeworks.homework09Addition.race.TimeLimitRace;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Garage garage = new Garage();
        List<Race> raceList = new ArrayList<Race>();

        try {
            FileReader fileReader = new FileReader("src/main/java/homeworks/homework09Addition/input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("src/main/java/homeworks/homework09Addition/output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while (bufferedReader.ready()) {
                String[] stringsArray = bufferedReader.readLine().split(",");
                String typeLine = "";
                String brand = "";
                String model = "";
                Integer year = 0;
                Integer horsepower = 0;
                Integer acceleration = 0;
                Integer suspension = 0;
                Integer durability = 0;
                Integer length = 0;
                String route = "";
                Integer prize = 0;
                Integer goldTime = 0;
                Integer laps = 0;

                if (stringsArray[0].matches("Car|PerformanceCar|ShowCar")) {
                    typeLine = stringsArray[0].trim();
                    brand = stringsArray[1].trim();
                    model = stringsArray[2].trim();
                    year = Integer.parseInt(stringsArray[3].trim());
                    horsepower = Integer.parseInt(stringsArray[4].trim());
                    acceleration = Integer.parseInt(stringsArray[5].trim());
                    suspension = Integer.parseInt(stringsArray[6].trim());
                    durability = Integer.parseInt(stringsArray[7].trim());
                } else if (stringsArray[0].matches("CasualRace|DragRace|DriftRace|TimeLimitRace|CircuitRace")){
                    typeLine = stringsArray[0].trim();
                    length = Integer.parseInt(stringsArray[1].trim());
                    route = stringsArray[2].trim();
                    prize = Integer.parseInt(stringsArray[3].trim());
                }
                if ((stringsArray[0].matches("TimeLimitRace|CircuitRace"))){
                    goldTime = Integer.parseInt(stringsArray[4].trim());
                    laps = Integer.parseInt(stringsArray[4].trim());
                }

                if (typeLine.equals("ShowCar")) {
                    garage.AddCarToGarage(new ShowCar(brand, model, year, horsepower, acceleration, suspension, durability));
                } else if (typeLine.equals("PerformanceCar")) {
                    garage.AddCarToGarage(new PerformanceCar(brand, model, year, horsepower, acceleration, suspension, durability));
                } else if (typeLine.equals("Car")) {
                    garage.AddCarToGarage(new Car(brand, model, year, horsepower, acceleration, suspension, durability));
                } else if (typeLine.equals("CasualRace")) {
                    raceList.add(new CasualRace(length, route, prize));
                } else if (typeLine.equals("DragRace")) {
                    raceList.add(new DragRace(length, route, prize));
                } else if (typeLine.equals("DriftRace")) {
                    raceList.add(new DriftRace(length, route, prize));
                } else if (typeLine.equals("TimeLimitRace")) {
                    raceList.add(new TimeLimitRace(length, route, prize, goldTime));
                } else if (typeLine.equals("CircuitRace")) {
                    raceList.add(new CircuitRace(length, route, prize, laps));
                }
            }
            bufferedWriter.write(garage.GetCarFromGarage() + "\r\n");

            for (Race i : raceList){
                bufferedWriter.write(i.toString() + "\r");
            }
            bufferedWriter.flush();
            fileReader.close();
            fileWriter.close();

        } catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
}
