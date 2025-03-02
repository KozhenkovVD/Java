package homeworks.homework13;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Person {
    private String name;
    private double balance;
    private List<Product> basket = new ArrayList<Product>();
    ;

    public Person(String name, double balance) {
        if (name.isEmpty()){
            System.out.println("Имя не может быть пустой строкой");
        }
        else if (balance < 0) {
            System.out.println("Деньги не могут быть отрицательными");
        } else {
            this.name = name;
            this.balance = balance;
        }
    }

    public String addProductToBasket(Product product) {
        if (this.balance < product.getPrice()) {
            return (this.name + " не может позволить себе " + product.getName());
        } else {
            this.basket.add(product);
            this.balance = balance - product.getPrice();
            return (this.name + " купил(а) " + product.getName());
        }
    }

    public String getProductFromBasket() {
        if (this.basket.size() == 0) {
            return (this.name + " - Ничего не куплено");
        } else {
            StringJoiner str = new StringJoiner(", ");
            for (Product product : this.basket) {
                str.add(product.getName());
            }
            return (this.name + " - " + str.toString()) ;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Имя не может быть пустой строкой");
        } else {
            this.name = name;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Деньги не могут быть отрицательными");
        } else {
            this.balance = balance;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(balance, person.balance) == 0 && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance);
    }
}
