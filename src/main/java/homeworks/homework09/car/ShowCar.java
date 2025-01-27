package homeworks.homework09.car;

import java.util.Arrays;
import java.util.Objects;

public class ShowCar extends Car{
    private Integer star;

    public ShowCar() {
    }

    public ShowCar(String brand, String model, Integer year, Integer horsepower, Integer acceleration, Integer suspension, Integer durability) {
        super(brand, model, year, horsepower, acceleration, suspension, durability);
        this.star = 0;
    }
    @Override
    public String toString() {
        return "ShowCar{" +
                "brand='" + super.getBrand() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", year=" + super.getYear() +
                ", horsepower=" + super.getHorsepower() +
                ", acceleration=" + super.getAcceleration() +
                ", suspension=" + super.getSuspension() +
                ", durability=" + super.getDurability() +
                ", star=" + star +
                "}";
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowCar showCar)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(star, showCar.star);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), star);
    }
}
