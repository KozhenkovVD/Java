package homeworks.homework07Addition.person;

import homeworks.homework07Addition.product.DiscountProduct;
import homeworks.homework07Addition.product.Product;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Adult extends Person {

    private Double credit;



    public Adult(String name, Double balance, Integer age, Double credit ) {
        super(name, balance, age);
        this.credit = credit;
    }
    @Override
    public void addProductToBasket(Product product) {
        if (product instanceof DiscountProduct) {
            DiscountProduct discountProduct = (DiscountProduct) product;
            if (LocalDate.now().isBefore(discountProduct.getDiscountDate())) {
                if (this.getBalance() < discountProduct.getPrice() * (1 - (double) discountProduct.getDiscount() / 100)) {
                    this.credit = getCredit() + (this.getBalance() - (discountProduct.getPrice() * (1 - (double) discountProduct.getDiscount() / 100))) * -1;
                    this.setBalance(0.00);
                    this.getBasket().add(discountProduct);
                    System.out.println(this.getName() + " купил(а) " + product.getName());
                } else {
                    this.setBalance(this.getBalance() - (discountProduct.getPrice() * (1 - (double) discountProduct.getDiscount() / 100)));
                    this.getBasket().add(discountProduct);
                    System.out.println(this.getName() + " купил(а) " + product.getName());
                }
            }
        } else {
            if (this.getBalance() < product.getPrice()) {
                this.setBalance(0.00);
                this.getBasket().add(product);
                this.credit = getCredit() + (this.getBalance() - product.getPrice()) * -1;
                System.out.println(this.getName() + " купил(а) " + product.getName());
            } else {
                this.getBasket().add(product);
                this.setBalance(this.getBalance()-product.getPrice());
                System.out.println(this.getName() + " купил(а) " + product.getName());
            }
        }
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Adult{" +
                "name='" + super.getName() +
                ", balance=" + super.getBalance() +
                ", basket=" + super.getBasket() +
                ", age=" + super.getAge() +
                ", credit=" + credit +
                '}';
    }

    @Override
    public String getProductFromBasket() {
        if (this.getBasket().size() == 0) {
            return (this.getName() + " - Ничего не куплено");
        } else {
            StringJoiner str = new StringJoiner(", ");
            for (Product product : this.getBasket()) {
                str.add(product.getName());
            }
            return (this.getName() + " - " + str.toString() + ". Баланс: " + this.getBalance() + ". Сумма кредита: " + this.getCredit());
        }
    }
}

