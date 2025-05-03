package app.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity{

    @Column(name = "login",nullable = false, unique = true)
    private String login;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customerId")
    private List<CartProduct> cartProducts;

}
