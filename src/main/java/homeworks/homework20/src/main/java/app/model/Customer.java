package app.model;

import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Data

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;

    public Customer(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
