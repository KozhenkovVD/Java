package model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;

}
