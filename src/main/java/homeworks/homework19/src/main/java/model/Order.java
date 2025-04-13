package model;


import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
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

}
