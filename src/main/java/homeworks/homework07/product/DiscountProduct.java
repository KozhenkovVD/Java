package homeworks.homework07.product;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product{
    private Integer discount;
    private LocalDate discountDate;


    public DiscountProduct(String name, Float price, Integer discount, LocalDate discountDate) {
        super(name, price);
        this.discount = discount;
        this.discountDate = discountDate;

    }



    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public LocalDate getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(LocalDate discountDate) {
        this.discountDate = discountDate;
    }



    @Override
    public String toString() {
        return "DiscountProduct{" +
                "name=" + super.getName() +
                ", price=" + super.getPrice() +
                ", discount=" + discount +
                ", discountDate=" + discountDate +
                '}';
    }


}
