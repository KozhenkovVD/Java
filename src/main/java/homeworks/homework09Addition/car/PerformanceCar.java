package homeworks.homework09Addition.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PerformanceCar extends Car {
    private List<String> addons = new ArrayList<String>() ;

    public PerformanceCar(String brand, String model, Integer year, Integer horsepower, Integer acceleration, Integer suspension, Integer durability) {
        super(brand, model, year, (int) (horsepower * 1.5), acceleration, (int) (suspension * 0.75), durability);
    }

    public PerformanceCar() {
    }

    public void AddAddon (String addon) {
        this.addons.add(addon);
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "brand='" + super.getBrand() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", year=" + super.getYear() +
                ", horsepower=" + super.getHorsepower() +
                ", acceleration=" + super.getAcceleration() +
                ", suspension=" + super.getSuspension() +
                ", durability=" + super.getDurability() +
                ", addOns=" + addons.toString() +
                "}";
    }

    public List<String> getAddons() {
        return addons;
    }

    public void setAddons(List<String> addons) {
        this.addons = addons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PerformanceCar that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(addons, that.addons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), addons);
    }
}
