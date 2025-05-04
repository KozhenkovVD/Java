package app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "in_date_time")
    private LocalDateTime inDateTime;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;

}
