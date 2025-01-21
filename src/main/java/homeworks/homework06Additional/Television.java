package homeworks.homework06Additional;

import homeworks.homework06.Product;

import java.util.ArrayList;
import java.util.Objects;

public class Television {

    private String producer;
    private String model;
    private Integer diagonal;
    private Float price;
    private Integer channel;
    private Integer volume;
    private Boolean isActive;
    private ArrayList<Channel> channelList = new ArrayList<Channel>();



    public Television(String producer, Integer channel, Integer volume, Boolean isActive) {
        this.producer = producer;
        this.channel = channel;
        this.volume = volume;
        this.isActive = isActive;
    }

    public void TurnOnOff(String on_off) {
        if (Objects.equals(on_off, "on")) {
            this.isActive = true;
        } else if (Objects.equals(on_off, "off")) {
            this.isActive = false;

        } else System.out.println("Неверно введено значение");
    }

    public void changeChanel(Integer channelNumber) {
        this.channel = channelNumber;
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
        return channel;
    }

    public void setChanel(Integer channel) {
        this.channel = channel;
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
                ", channel=" + channel +
                ", volume=" + volume +
                ", isActive=" + isActive +
                ", channelList=" + channelList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return Objects.equals(producer, that.producer) && Objects.equals(model, that.model) && Objects.equals(diagonal, that.diagonal) && Objects.equals(price, that.price) && Objects.equals(channel, that.channel) && Objects.equals(volume, that.volume) && Objects.equals(isActive, that.isActive) && Objects.equals(channelList, that.channelList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model, diagonal, price, channel, volume, isActive, channelList);
    }
}
