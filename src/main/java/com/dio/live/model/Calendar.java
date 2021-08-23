package com.dio.live.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Calendar {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "data_type_id")
    private DataType dataType;
    private String description;
    private LocalDateTime specialDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Calendar calendar = (Calendar) o;

        return Objects.equals(id, calendar.id);
    }

    @Override
    public int hashCode() {
        return 1793912679;
    }
}
