package homeworks.homework03;

public class Television {

    private String producer;
    private String model;
    private Integer diagonal;
    private Float price;


    public Television(String producer, String model, Integer diagonal, Float price) {
        this.producer = producer;
        this.model = model;
        this.diagonal = diagonal;
        this.price = price;
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

    @Override
    public String toString() {
        return "Television{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", diagonal=" + diagonal +
                ", price=" + price +
                '}';
    }
}