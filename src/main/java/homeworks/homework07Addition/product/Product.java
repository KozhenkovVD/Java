package homeworks.homework07Addition.product;

import java.util.Objects;

public class Product {
    private String name;
    private Float price;
    private Boolean forChild;

    public Product(String name, Float price) {
        if (name.isEmpty()) {
            System.out.println("Имя не может быть пустой строкой");
        } else if (price <= 0) {
            System.out.println("Цена не может быть равна 0 или отрицательной");
        }
        else {
            this.name = name;
            this.price = price;
        }
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        if (price < 0) {
            System.out.printf("Цена не может быть отрицательным");
        } else {
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.printf("Имя не может быть пустой строкой");
        } else {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
