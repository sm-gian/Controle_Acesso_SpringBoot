package com.dio.live.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Flow {
        @AllArgsConstructor
        @NoArgsConstructor
        @EqualsAndHashCode
        @Embeddable
        public static class FlowId implements Serializable{
            private long flowId;
            private long userId;
        }
        @EmbeddedId
        private FlowId id;
        private LocalDateTime entryDate;
        private LocalDateTime outputDate;
        private BigDecimal period;
        @ManyToOne
        @JoinColumn(name = "occurrence_id")
        private Occurrence occurrence;

        @ManyToOne
        @JoinColumn(name = "calendar_id")
        private Calendar calendar;

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
                Flow flow = (Flow) o;

                return Objects.equals(id, flow.id);
        }

        @Override
        public int hashCode() {
                return Objects.hashCode(id);
        }
}
