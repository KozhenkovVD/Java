package app.model;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Order {
    private Integer id;
    private Integer customerId;
    private LocalDate orderDate;
    private Integer ordersCount;
    private Integer discount;

    public Order(Integer id, Integer customerId, LocalDate orderDate, Integer ordersCount, Integer discount) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.ordersCount = ordersCount;
        this.discount = discount;
    }
}
