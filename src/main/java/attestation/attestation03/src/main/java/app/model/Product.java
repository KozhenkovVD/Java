package app.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "type", nullable = false)
    private ProductType type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;


}