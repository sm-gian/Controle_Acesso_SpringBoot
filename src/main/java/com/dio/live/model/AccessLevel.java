package com.dio.live.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AccessLevel {
    @Id
    private long id;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccessLevel that = (AccessLevel) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1193116180;
    }
}
