package homeworks.homework07Addition.person;

import homeworks.homework07Addition.product.DiscountProduct;
import homeworks.homework07Addition.product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Person {
    private String name;
    private Double balance;
    private List<Product> basket = new ArrayList<Product>();
    private Integer age;
    ;

    public Person(String name, double balance, Integer age) {
        if (name.isEmpty()){
            System.out.println("Имя не может быть пустой строкой");
        }
        else if (balance < 0) {
            System.out.println("Деньги не могут быть отрицательными");
        } else {
            this.name = name;
            this.balance = balance;
            this.age = age;
        }
    }

    public void addProductToBasket(Product product) {
        if (product instanceof DiscountProduct) {
            DiscountProduct discountProduct = (DiscountProduct) product;
            if (LocalDate.now().isBefore(discountProduct.getDiscountDate())) {
                if (this.balance < discountProduct.getPrice() * (1 - (double) discountProduct.getDiscount() / 100)) {
                    System.out.println(this.name + " не может позволить себе " + discountProduct.getName());
                } else {
                    this.basket.add(discountProduct);
                    this.balance -= discountProduct.getPrice() * (1 - (double) discountProduct.getDiscount() / 100);
                    System.out.println(this.name + " купил(а) " + discountProduct.getName());
                }
            }
        } else {
            if (this.balance < product.getPrice()) {
                System.out.println(this.name + " не может позволить себе " + product.getName());
            } else {
                this.basket.add(product);
                this.balance -= product.getPrice();
                System.out.println(this.name + " купил(а) " + product.getName());
            }
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
            return (this.name + " - " + str.toString() + ". Баланс: " + this.getBalance()) ;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        if (balance < 0) {
            System.out.println("Деньги не могут быть отрицательными");
        } else {
            this.balance = balance;
        }
    }



    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", basket=" + basket +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(name, person.name) && Objects.equals(balance, person.balance) && Objects.equals(basket, person.basket) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance, basket, age);
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }


}
