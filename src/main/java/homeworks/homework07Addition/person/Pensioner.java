package homeworks.homework07Addition.person;

import homeworks.homework07Addition.product.DiscountProduct;
import homeworks.homework07Addition.product.Product;

import java.time.LocalDate;

public class Pensioner extends Person{

    public Pensioner(String name, Double balance, Integer age) {
        super(name, balance, age);
    }

    @Override
    public String toString() {
        return "Pensioner{" +
                "name='" + super.getName() +
                ", balance=" + super.getBalance() +
                ", basket=" + super.getBasket() +
                ", age=" + super.getAge() +
                '}';
    }
    @Override
    public void addProductToBasket(Product product) {
        if (product instanceof DiscountProduct) {
            DiscountProduct discountProduct = (DiscountProduct) product;
            if (LocalDate.now().isBefore(discountProduct.getDiscountDate())) {
                if (this.getBalance() < discountProduct.getPrice() * (1 - ((double) discountProduct.getDiscount() + 5)/100)) {
                    System.out.println(this.getName() + " не может позволить себе " + discountProduct.getName());
                } else {
                    this.getBasket().add(discountProduct);
                    this.setBalance(this.getBalance() - discountProduct.getPrice() * (1 - ((double) discountProduct.getDiscount() + 5)/100)) ;
                    System.out.println(this.getName() + " купил(а) " + discountProduct.getName());
                }
            }
        } else {
            if (this.getBalance() < product.getPrice()  * (1 - (double) 5/100)) {
                System.out.println(this.getName() + " не может позволить себе " + product.getName());
            } else {
                this.getBasket().add(product);
                this.setBalance(this.getBalance() - product.getPrice() * (1 - (double) 5/100)); ;
                System.out.println(this.getName() + " купил(а) " + product.getName());
            }
        }
    }
}
