package homeworks.homework07Addition.person;

import homeworks.homework07Addition.product.Product;

public class Child extends Person {


    public Child(String name, double balance, Integer age) {
        super(name, balance, age);
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + super.getName() +
                ", balance=" + super.getBalance() +
                ", basket=" + super.getBasket() +
                ", age=" + super.getAge() +
                '}';
    }

    @Override
    public void addProductToBasket(Product product) {
        if (super.getAge() < 6) {
            System.out.println("Дети младше 6 лет не могут покупать товары");
        } else {
            super.addProductToBasket(product);
        }
    }
}
