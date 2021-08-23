package com.dio.live.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_category_id")
    private UserCategory userCategory;
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "access_level_id")
    private AccessLevel accessLevel;

    @ManyToOne
    @JoinColumn(name = "work_day_id")
    private WorkDay workDay;
    private BigDecimal tolerance;
    private LocalDateTime workDayStart;
    private LocalDateTime workDayEnd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;

        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return 562048007;
    }
}
