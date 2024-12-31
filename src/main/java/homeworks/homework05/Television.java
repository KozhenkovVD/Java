package homeworks.homework05;

import java.util.ArrayList;
import java.util.Objects;

public class Television {

    private String producer;
    private String model;
    private Integer diagonal;
    private Float price;
    private Chanel chanel;
    private Integer volume;
    private Boolean isActive;




    public Television(String producer, Integer volume, Boolean isActive) {
        this.producer = producer;
        this.volume = volume;
        this.isActive = isActive;
    }

    public Television(String lg, int volume, boolean isActive, int i) {
    }

    public void TurnOnOff(String on_off) {
        if (on_off == "on") {
            this.isActive = true;
        } else if (on_off == "off") {
            this.isActive = false;

        } else System.out.println("Неверно введено значение");
    }


    public void changeChanel(Chanel chanelNumber) {
        this.chanel = chanelNumber;
    }


    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Integer diagonal) {
        this.diagonal = diagonal;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getChanel() {
        return chanel.getNumber();
    }

    public void setChanel(Chanel chanel) {
        this.chanel = chanel;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Television{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", diagonal=" + diagonal +
                ", price=" + price +
                ", chanel=" + chanel +
                ", volume=" + volume +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return Objects.equals(producer, that.producer) && Objects.equals(model, that.model) && Objects.equals(diagonal, that.diagonal) && Objects.equals(price, that.price) && Objects.equals(chanel, that.chanel) && Objects.equals(volume, that.volume) && Objects.equals(isActive, that.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model, diagonal, price, chanel, volume, isActive);
    }



}
