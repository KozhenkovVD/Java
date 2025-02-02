package homeworks.homework11;

import java.util.Objects;

public class Car {
    private String number;
    private String model;
    private String color;
    private Integer mileage;
    private Integer price;

    public Car(String number, String model, String color, Integer mileage, Integer price) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(number, car.number) && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(mileage, car.mileage) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, model, color, mileage, price);
    }
}
