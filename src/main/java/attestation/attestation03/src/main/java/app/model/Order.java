package app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "in_date_time")
    private LocalDateTime inDateTime;

    @OneToMany(mappedBy = "orderId")
    private List<OrderProduct> orderProductsList;

}