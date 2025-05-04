package app.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor

@Builder
@Table(name = "cart_products_list")
@NoArgsConstructor(force = true)

public class CartProduct extends BaseEntity {

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @JoinColumn(name = "product_id", nullable = false)
    @OneToOne
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;


}
