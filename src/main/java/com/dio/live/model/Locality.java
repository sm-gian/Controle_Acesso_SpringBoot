package com.dio.live.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Locality {
    @Id
    private long id;
    @ManyToOne
    private AccessLevel accessLevel;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Locality locality = (Locality) o;

        return Objects.equals(id, locality.id);
    }

    @Override
    public int hashCode() {
        return 1023553853;
    }
}
